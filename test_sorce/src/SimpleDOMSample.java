      import java.io.*;
      import org.w3c.dom.Document;
      import org.w3c.dom.Node;
      import javax.xml.parsers.*;

       public class SimpleDOMSample{

           public static void main(String args[]) throws Exception{

              Document document= DocumentBuilderFactory
                  .newInstance()
                  .newDocumentBuilder()
                  .parse(new File("helloWorld.xml"));


              Node node=document.getDocumentElement();
              Node childNode=node.getFirstChild();

              System.out.println(childNode);
          }

      }