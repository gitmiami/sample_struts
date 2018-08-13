
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

    //���L�̓��e��o�^����SQL
    private static final String INSERTSQL = "insert into diary values(?,?,?)";
    
    //���L�̓��e���X�V����SQL
    private static final String UPDATESQL = "update diary set content = ?,imgFileUrl = ? where date = ?";

    //���L�ꗗ���擾����SQL
    private static final String SELECTSQL = "select * from diary order by date";
    
    //�X�V���e���쐬���邽�߂ɑO�̓��e�����o��SQL
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

            //1)model.Diary�̃��X�g���擾���郍�W�b�N���Ϗ����Ă���
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
            //2)ResultSet����l�����o���āAmodel.Diary���쐬��������Ϗ����Ă���
            list.add(getDiary(rs));
        }
        return list;
    }

    private Diary getDiary(ResultSet rs) throws SQLException {
        //3)ResultSet����l�����o���āAmodel.Diary���쐬����
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

        //�Â����͂��e�[�u��������o���B
        PreparedStatement selectStmt = con.prepareStatement(SELECTCONTENTSQL);
        PreparedStatement stmt = con.prepareStatement(UPDATESQL);

        ResultSet rs = null;
        try{
           selectStmt.setDate(1, date);
           rs = selectStmt.executeQuery();
           if (rs.next()) {
               updateContent.append(rs.getString("content"));
           }

           //�Â����͂ɐV�������e��ǉ�����
           updateContent.append(content);

           //4)�X�V����SQL�����s
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