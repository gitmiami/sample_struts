package xmlReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class xmlRead {
    /** XMLのエンコード */
    private static final String XML_ENCODING_UTF8 = "UTF-8";
    /** XFDファイル内の日本語文字列の文字コード */
    private static final String TYPE_MS932 = "MS932";

	static byte[] buffer = null; // ファイルのbyteサイズ配列




    public XfdFileInfo getXfdFileData(String xfdString) throws Exception {

    	/** サービスIDのタグ名称 */
        String SERVICE_TAG = "service";

        XfdFileInfo xfdFileInfo = new XfdFileInfo();

        Element doc = getDocumentElement(xfdString);

        //対象のタグデータ取得
        //受付ID
        xfdFileInfo.uketsukeId = getTagValue(doc, XfdFileInfo.UKETSUKE_ID_TAG);
        /** オーダ登録番号 */
        xfdFileInfo.orderNo =  getTagValue(doc, XfdFileInfo.ORDER_NO_TAG);
        /** お客番号 */
        xfdFileInfo.keiName = getTagValue(doc, XfdFileInfo.KEI_NAME_TAG);
        /** 開通/変更/廃止希望日 */
        xfdFileInfo.kaitsuuDate = getTagValue(doc, XfdFileInfo.KAITSUU_DATE_TAG);
        /** お客様対応部門担当者 */
        xfdFileInfo.taiouName = getTagValue(doc, XfdFileInfo.TAIOU_NAME_TAG);
        /** お客様対応部門TEL */
        xfdFileInfo.taiouTel = getTagValue(doc, XfdFileInfo.TAIOU_TEL_TAG);
        /** お客様対応部門e-mail */
        xfdFileInfo.taiouMain = getTagValue(doc, XfdFileInfo.TAIOU_MAIL_TAG);
        /** サービスID */
        xfdFileInfo.service = getTagValue(doc, SERVICE_TAG);


        return xfdFileInfo;
    }

    /**
     * 指定されたXMLデータから、ドキュメントルートを取得して返します。
     * @param data XMLデータ
     */
    private Element getDocumentElement(String data) throws Exception {

        String methodName = "createDomDocument";

        // ドキュメントビルダーファクトリを生成
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        // ドキュメントビルダーを生成
        DocumentBuilder builder = null;
        try {
            builder = dbfactory.newDocumentBuilder();
        } catch (Exception e) {

            throw new Exception();
        }

        // パースを実行してDocumentオブジェクトを取得
        Document doc = null;
        ByteArrayInputStream byteXMLData = null;
        try {
            byteXMLData = new ByteArrayInputStream(data.getBytes(XML_ENCODING_UTF8));
            doc = builder.parse(byteXMLData);
        } catch (Exception e) {

            throw new Exception();
        } finally {
            if (byteXMLData != null) {
                try {
                    byteXMLData.close();
                } catch (IOException ioe) {

                    throw new Exception();
                }
            }
        }

        // ルート要素を取得
        return doc.getDocumentElement();
    }
    /**
     * 指定されたドキュメントから、指定されたタグ名のタグの値を返します。
     * タグが存在しなかった場合、nullを返します。
     * @param doc       DOMドキュメント
     * @param tagName   タグ名
     */
    private String getTagValue(Element doc, String tagName) throws Exception {
        NodeList nodeList = doc.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            NodeList childList = nodeList.item(0).getChildNodes();
            if (childList != null) {
                for (int i = 0; i < childList.getLength(); i++) {
                    Node node = childList.item(i);
                    if (node.getNodeType() == Element.TEXT_NODE) {
                        try {
                            return new String(node.getNodeValue().getBytes(TYPE_MS932));
                        } catch (Exception e) {
                        	throw new Exception();
                        }
                    }
                }
            }
        }
        return null;
    }

}


