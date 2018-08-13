package xmlReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import sec1.FileInfo;

public class loop1 {

	// ■■■■■■■■■■■■■■■■■■■■■■■

	public static ArrayList alTX = null;

	public File uploadFile; // アップロードファイル
	public String filePath; // アップロードファイルのPATH
	public String fileName; // アップロードファイル名
	public String fileSize; // アップロードファイルサイズ
	public String applicationId; // 申込書ID
	public String fileString; // ファイル内容
	public byte[] fileBuffer; // ファイル内容（バイト）

	static FileInputStream fis = null; // 文字化する時、使用するファイルオブジェクト
	static byte[] buffer = null; // ファイルのbyteサイズ配列
	static String encodeString = null;// エンコードする変数

	// ■■■■■■■■■■■■■■■■■■■■■■■

	public static void main(String[] args) throws IOException {

		alTX = makeListTX();

		for (int h = 0; h < alTX.size(); h++) {

			try {
				System.out.println(" ■■■■■■■■■■■       " + h + "    回目 ■■■■■■■■■■■");
				System.out.println(alTX.get(h));


				// ■■■■■■■■■■■■■■■■■■■■■■■
				FileInfo fileInfo = new FileInfo();

				File fileObject = new File("c:\\1_javatest");
				File fileObject2 = new File("c:\\1_javatest\\"+ alTX.get(h));
				//File fileObject2 = new File("c:\\aa\\bbvvv.txt");
				// File fileObject2 = new File("c:\\aa\\as.xls");
				// ディレクトリから読込み

				// ■■■■■■■■■■■■■■■■■■■■■■■
				String filelist[] = fileObject.list();
				for (int i = 0; i < filelist.length; i++) {
					System.out.println(filelist[i]);
					System.out.println(filelist[i].length());
				}


				// ■■■■■■■■■■■■■■■■■■■■■■■
				// 1-2送信されたファイル内容の文字列化（アップロードファイルを文字化)
				buffer = new byte[(int) fileObject2.length()];
				fis = new FileInputStream(fileObject2);// ディレクトリ名一歩前
				fis.read(buffer);

				System.out.println("                                              ");
				System.out.println(" buffer　→→→→→→→→→      " + buffer);
				// ■■■■■■■■■■■■■■■■■■■■■■■

				// SJISにエンコード
				encodeString = new String(buffer, "SJIS");

				// Encodingしない。
				// encodeString = buffer.toString();

				// ファイルオブジェクトをクローズする。
				if (fis != null) {
					fis.close();
				}
				// ■■■■■■■■■■■■■■■■■■■■■■■
				//結果出力処理
				System.out.println("                                              ");
				System.out.println(" エンコードされたストリング　encodeString　→→→→→→→→→      "
						+ encodeString);

				fileInfo.fileBuffer = buffer;
				fileInfo.fileString = encodeString;

				System.out.println(" fileBuffer　　→→→→→→→→→      "
						+ fileInfo.fileBuffer);
				System.out.println("                                                       ");
				System.out.println(" fileString　　→→→→→→→→→      "
						+ fileInfo.fileString);



				System.out.println("                                                       ");
				System.out.println("              the end            ");
				System.out.println("                                                       ");
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


		}//for end

	}//main end

	public static ArrayList makeListTX() {

		ArrayList allyTX = new ArrayList();

		allyTX.add("tx1FileName.txt");
		allyTX.add("tx2FileName.txt");
		allyTX.add("tx3FileName.txt");

		return allyTX;
	}

}
