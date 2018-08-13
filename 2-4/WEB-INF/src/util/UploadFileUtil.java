
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
        //FormFileインタフェースのgetFileName()メソッドはパスを含まずファイル名だけを返すので
        //ファイル名にimgフォルダを追加して相対パスを組み立てている
        String filePath = IMGDIR + "/" + baseName;
        return filePath;
    }

    public void write(String filePath, FormFile fForm) throws IOException { 
        
        //1)ServletContextクラスを利用して絶対パスを取得
        String realPath = context.getRealPath(filePath);
        OutputStream out = new FileOutputStream(realPath);
        
        //2)FormFileクラスを利用してアップロードファイルを書き込む
        out.write(fForm.getFileData(), 0, fForm.getFileSize());
        out.close();
    }
    
}
