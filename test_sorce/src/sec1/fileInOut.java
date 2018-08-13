package sec1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class fileInOut {


    // ********************************************

	public File uploadFile;      // アップロードファイル
    public String filePath;      // アップロードファイルのPATH
    public String fileName;      // アップロードファイル名
    public String fileSize;      // アップロードファイルサイズ
    public String applicationId; // 申込書ID
    public String fileString;    // ファイル内容
    public byte[] fileBuffer;   //ファイル内容（バイト）

    static FileInputStream fis = null; // 文字化する時、使用するファイルオブジェクト
    static byte[] buffer = null; // ファイルのbyteサイズ配列
    static String encodeString = null;//エンコードする変数

    // ********************************************



	  public static void main (String[] args)  {

    	 fileInOut mLogic = new fileInOut();

    	 try {
    		 //method1 start

    		 mLogic.method1();

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	  }
	  //main end



	void method1() throws Exception {

		try {

			FileInfo fileInfo = new FileInfo();

			File fileObject = new File("c:\\aa");
			File fileObject2 = new File("c:\\aa\\bbvvv.txt");
			//File fileObject2 = new File("c:\\aa\\as.xls");
			// ディレクトリから読込み

			String filelist[] = fileObject.list();
			for (int i = 0; i < filelist.length; i++) {
				System.out.println(filelist[i]);
				System.out.println(filelist[i].length());
			}

			System.out.println("              end  1111           ");

			// 1-2送信されたファイル内容の文字列化（アップロードファイルを文字化)
			buffer = new byte[(int) fileObject2.length()];
			fis = new FileInputStream(fileObject2);// ディレクトリ名一歩前
			fis.read(buffer);

			System.out.println(" buffer　→→→→→→→→→      " + buffer);

			// SJISにエンコード
			encodeString = new String(buffer, "SJIS");

			// Encodingしない。
			// encodeString = buffer.toString();

			// ファイルオブジェクトをクローズする。
			if (fis != null) {
				fis.close();
			}

			System.out.println(" エンコードストリング　encodeString　→→→→→→→→→      "
					+ encodeString);

			fileInfo.fileBuffer = buffer;
			fileInfo.fileString = encodeString;


			System.out.println(" fileBuffer　　→→→→→→→→→      " + fileInfo.fileBuffer);
			System.out.println("                                                       ");
			System.out.println(" fileString　　→→→→→→→→→      " + fileInfo.fileString);


			System.out.println("              end   222            ");



		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} finally {
			try {
				// ファイルオブジェクトをクローズする。
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
