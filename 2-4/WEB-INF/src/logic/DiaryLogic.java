
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
        
        //1)FormFile�N���X�𗘗p���đ��M���ꂽ�t�@�C�������擾����
        String filePath = fForm.getFileName();
        
        //2)�t�@�C�������󕶎���̏ꍇ�͏������܂Ȃ����A����ȊO�̏ꍇ�̓t�@�C�����쐬����
        if(!("".equals(filePath))){
            filePath = util.getFilePath(filePath);
            util.write(filePath,fForm);
        }

        try{
            dao.entryContents(entryDate,content,filePath);
        }catch(SQLException ex){
            //3)���͂��ꂽ���t���d�Ȃ����ꍇ�͍X�V����
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
