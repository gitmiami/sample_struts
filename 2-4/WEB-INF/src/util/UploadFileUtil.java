
package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts.upload.FormFile;

public class UploadFileUtil {
    
    private static final String IMGDIR ="img";    
    
    private ServletContext context;
    
    public UploadFileUtil(ServletContext ctx){
        context = ctx;
    }
    
    public String getFilePath(String baseName) {
        //FormFile�C���^�t�F�[�X��getFileName()���\�b�h�̓p�X���܂܂��t�@�C����������Ԃ��̂�
        //�t�@�C������img�t�H���_��ǉ����đ��΃p�X��g�ݗ��ĂĂ���
        String filePath = IMGDIR + "/" + baseName;
        return filePath;
    }

    public void write(String filePath, FormFile fForm) throws IOException { 
        
        //1)ServletContext�N���X�𗘗p���Đ�΃p�X���擾
        String realPath = context.getRealPath(filePath);
        OutputStream out = new FileOutputStream(realPath);
        
        //2)FormFile�N���X�𗘗p���ăA�b�v���[�h�t�@�C������������
        out.write(fForm.getFileData(), 0, fForm.getFileSize());
        out.close();
    }
    
}
