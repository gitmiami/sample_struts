
package logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import model.Diary;

import org.apache.struts.upload.FormFile;

import dao.DiaryContentDao;

import util.UploadFileUtil;

public class DiaryLogic {

    private static final int DUPKEYERRCODE = 1062;
    private DiaryContentDao dao;
    
    public DiaryLogic(DataSource src){
        dao =  new DiaryContentDao();
        dao.setDataSource(src);
    }
    
    public void entry(Date entryDate,String content,FormFile fForm,UploadFileUtil util) throws SQLException, FileNotFoundException, IOException {
        
        //1)FormFileクラスを利用して送信されたファイル名を取得する
        String filePath = fForm.getFileName();
        
        //2)ファイル名が空文字列の場合は書き込まないが、それ以外の場合はファイルを作成する
        if(!("".equals(filePath))){
            filePath = util.getFilePath(filePath);
            util.write(filePath,fForm);
        }

        try{
            dao.entryContents(entryDate,content,filePath);
        }catch(SQLException ex){
            //3)入力された日付が重なった場合は更新する
            if(ex.getErrorCode() == DUPKEYERRCODE){
                dao.updateContents(entryDate,content,filePath);
            }
        }
    }
    
    public List<Diary> getDiaryContents() throws SQLException{
    
        List<Diary> list = dao.getContents();
        return list;
    }
    
}
