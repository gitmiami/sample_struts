import java.io.*;

public class HelloWorldFileReader {
  public static void main(String[] args) {
    try {
      FileInputStream fis = new FileInputStream("hello.txt");
      InputStreamReader ir = new InputStreamReader(fis , "MS932");

      BufferedReader br = new BufferedReader(ir);
      String msg = br.readLine();
      // 表示
      System.out.println(msg);

      fis.close();
      ir.close();
      fis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}