import java.io.*;

public class HelloWorldFileWriter {
  public static void main(String[] args) {
    try {
      FileOutputStream fos = new FileOutputStream("hello.txt");
      OutputStreamWriter osw = new OutputStreamWriter(fos , "MS932");

      BufferedWriter bw = new BufferedWriter(osw);
      String msg = "こんにちは　世界";
      bw.write(msg);

      bw.close();
      osw.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}