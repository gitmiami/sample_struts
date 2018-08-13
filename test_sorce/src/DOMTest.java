import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMTest {

    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("./sample.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(bis);

            // ルート要素の取得
            Element root = doc.getDocumentElement();

            // タグ名の表示
            System.out.println(root.getTagName());
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
