package xmlReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class trigerXmlReader {

	public static void main(String[] args) throws IOException {


		// ■■■■■■■■■■■■■■■■■■■■■■■
		byte[] fileBuffer; // ファイル内容（バイト）
		 FileInputStream fis = null; // 文字化する時、使用するファイルオブジェクト
		 byte[] buffer = null; // ファイルのbyteサイズ配列
		 String encodeString = null;// エンコードする変数
		// ■■■■■■■■■■■■■■■■■■■■■■■

		xmlRead objXmlReader = new xmlRead();

		File fileObject2 = new File("c:\\1_javatest\\tx1FileName.xml");

		// ■■■■■■■■■■■■■■■■■■■■■■■
		// 1-2送信されたファイル内容の文字列化（アップロードファイルを文字化)
		buffer = new byte[(int) fileObject2.length()];
		fis = new FileInputStream(fileObject2);// ディレクトリ名一歩前
		fis.read(buffer);

		// SJISにエンコード
		encodeString = new String(buffer, "SJIS");

		try {

	        XfdFileInfo getXfdFileInfo = new XfdFileInfo();

			getXfdFileInfo = objXmlReader.getXfdFileData(encodeString);

			System.out.println(getXfdFileInfo.keiName);
			System.out.println(getXfdFileInfo.orderNo);
			System.out.println(getXfdFileInfo.kaitsuuDate);

		} catch (Exception e) {

			e.printStackTrace();

		}


	}
}

