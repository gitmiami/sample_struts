package xmlReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class loop2 {

	// ■■■■■■■■■■■■■■■■■■■■■■■

	public static ArrayList alTX = null;

	static FileInputStream fis = null; // 文字化する時、使用するファイルオブジェクト
	static byte[] buffer = null; // ファイルのbyteサイズ配列
	static String encodeString = null;// エンコードする変数

	static XfdFileInfo getXfdFileInfo = null;


	// ■■■■■■■■■■■■■■■■■■■■■■■

	public static void main(String[] args) throws IOException {

		alTX = makeListTX();

		for (int h = 0; h < alTX.size(); h++) {

			//xmlリーダー読み込み
			xmlRead objXmlReader = new xmlRead();

			File fileObject2 = new File("c:\\1_javatest\\"+ alTX.get(h));

		//エラー系
		//	File fileObject2 = new File("c:\\bb\\txcFileName.xml");

			// ■■■■■■■■■■■■■■■■■■■■■■■
			// 1-2送信されたファイル内容の文字列化（アップロードファイルを文字化)
//			buffer = new byte[(int) fileObject2.length()];
//			fis = new FileInputStream(fileObject2);// ディレクトリ名一歩前
//			fis.read(buffer);

			buffer = getBuffer(fileObject2.toString());

			// SJISにエンコード
			encodeString = new String(buffer, "SJIS");


			try {

		        //XfdFileInfo getXfdFileInfo = new XfdFileInfo();

				getXfdFileInfo = new XfdFileInfo();

				getXfdFileInfo = objXmlReader.getXfdFileData(encodeString);

				System.out.println(getXfdFileInfo.keiName);
				System.out.println(getXfdFileInfo.orderNo);
				System.out.println(getXfdFileInfo.kaitsuuDate);
				System.out.println("          ");
				System.out.println("          ");
				System.out.println("          ");

			} catch (Exception e) {


				e.printStackTrace();

			}




		}
	}

	public static ArrayList makeListTX() {

		ArrayList allyTX = new ArrayList();

		allyTX.add("tx1FileName.xml");
//		allyTX.add("tx2FileName.xml");
//		allyTX.add("tx3FileName.xml");

		return allyTX;
	}


	public static byte[] getBuffer(String path) {

		File fileObject = new File(path);
		FileInputStream fis = null;

		// ファイルのbyte配列
		byte[] buffer = new byte[(int) fileObject.length()];

		try {

			fis = new FileInputStream(fileObject);
			fis.read(buffer);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return buffer;

	}


}
