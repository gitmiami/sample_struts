import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class xmltest {

	  public static void main (String[] args) {
		  xmltest objXml = new xmltest();

			System.out.println("start             ");

		  objXml.getDocumentElement("kani_atamagami.xfd");

		  System.out.println("end             ");

	  }


    /**
     * 指定されたXMLデータから、ドキュメントルートを取得して返します。
     * @param data XMLデータ
     */
    private Element getDocumentElement(String data)    {

        String methodName = "createDomDocument";

        // ドキュメントビルダーファクトリを生成
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        // ドキュメントビルダーを生成
        DocumentBuilder builder = null;
        try {
            builder = dbfactory.newDocumentBuilder();
        } catch (Exception e) {


        }

        // パースを実行してDocumentオブジェクトを取得
        Document doc = null;
        ByteArrayInputStream byteXMLData = null;
        try {
            byteXMLData = new ByteArrayInputStream(data.getBytes("UTF-8"));
            doc = builder.parse(byteXMLData);
        } catch (Exception e) {




        } finally {
            if (byteXMLData != null) {
                try {
                    byteXMLData.close();
                } catch (IOException ioe) {



                }
            }
        }

        // ルート要素を取得
        return doc.getDocumentElement();
    }
}