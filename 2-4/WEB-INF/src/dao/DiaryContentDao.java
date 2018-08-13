
package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Diary;

public class DiaryContentDao {

    //日記の内容を登録するSQL
    private static final String INSERTSQL = "insert into diary values(?,?,?)";
    
    //日記の内容を更新するSQL
    private static final String UPDATESQL = "update diary set content = ?,imgFileUrl = ? where date = ?";

    //日記一覧を取得するSQL
    private static final String SELECTSQL = "select * from diary order by date";
    
    //更新内容を作成するために前の内容を取り出すSQL
    private static final String SELECTCONTENTSQL = "select content,imgFileUrl from diary where date = ?";

    private DataSource ds;

    public void setDataSource(DataSource source) {
        ds = source;
    }

    public void entryContents(Date date, String contents, String filePath)
            throws SQLException {
        
        Connection con = ds.getConnection();

        PreparedStatement stmt = con.prepareStatement(INSERTSQL);

        try{
           stmt.setDate(1, new java.sql.Date(date.getTime()));
           stmt.setString(2, contents);
           stmt.setString(3, filePath);

           stmt.executeUpdate();
        }catch(SQLException ex){
           throw ex;
        }finally{
          stmt.close();
          con.close();
        }
    }


    public List<Diary> getContents() throws SQLException {

        Connection con = ds.getConnection();
        PreparedStatement stmt = con.prepareStatement(SELECTSQL);
        ResultSet rs = null;
        
        try{
            rs = stmt.executeQuery();

            //1)model.Diaryのリストを取得するロジックを委譲している
            List<Diary> list = getDiaries(rs);
            return list;

        }catch(SQLException ex){
            throw ex;
        }finally{
            if(rs != null){
                rs.close();
            }
            stmt.close();
            con.close();
        }

    }

    private List<Diary> getDiaries(ResultSet rs) throws SQLException {
        List<Diary> list = new ArrayList<Diary>();
        while (rs.next()) {
            //2)ResultSetから値を取り出して、model.Diaryを作成する個所を委譲している
            list.add(getDiary(rs));
        }
        return list;
    }

    private Diary getDiary(ResultSet rs) throws SQLException {
        //3)ResultSetから値を取り出して、model.Diaryを作成する
        Diary dairy = new Diary();
        dairy.setDate(rs.getString("date"));
        dairy.setContent(rs.getString("content"));
        dairy.setImgFileUrl(rs.getString("imgFileUrl"));
        return dairy;
    }


    public void updateContents(Date entryDate, String content, String filePath)
            throws SQLException {
        
        Connection con = ds.getConnection();

        java.sql.Date date = new java.sql.Date(entryDate.getTime());
        StringBuffer updateContent = new StringBuffer();

        //古い文章をテーブルから取り出す。
        PreparedStatement selectStmt = con.prepareStatement(SELECTCONTENTSQL);
        PreparedStatement stmt = con.prepareStatement(UPDATESQL);

        ResultSet rs = null;
        try{
           selectStmt.setDate(1, date);
           rs = selectStmt.executeQuery();
           if (rs.next()) {
               updateContent.append(rs.getString("content"));
           }

           //古い文章に新しい内容を追加する
           updateContent.append(content);

           //4)更新するSQLを実行
           stmt.setString(1, updateContent.toString());
           stmt.setString(2, filePath);
           stmt.setDate(3, date);
           stmt.executeUpdate();

       }catch(SQLException ex){
            throw ex;
       }finally{
            if(rs != null){
                rs.close();
            }
            selectStmt.close();
            stmt.close();
            con.close();  
       }
    }

}