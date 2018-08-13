package sec1;
/****************************************************************************************
 * １.ファイル名：FileInfo.java
 * ２．クラス   ：FileInfo  ファイルデータ情報クラス「ファイルデータ」を格納する構造体
 * ３．Version  ：1.0
 * ４．履歴     ：
 *      1.0     08-May-2007    E.Kim     作成
 ****************************************************************************************/
 

import java.io.File;
import java.io.Serializable;

public class FileInfo implements Serializable {
    public File uploadFile;      // アップロードファイル
    public String filePath;      // アップロードファイルのPATH
    public String fileName;      // アップロードファイル名
    public String fileSize;      // アップロードファイルサイズ
    public String applicationId; // 申込書ID
    public String fileString;    // ファイル内容
    public byte[] fileBuffer;   //ファイル内容（バイト）
}
