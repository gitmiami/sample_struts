import java.net.*;
import java.io.*;

public class HelloWorldSocketClient {
  public static void main(String[] args){
    try{
      // ソケットを生成
      Socket socket = new Socket("localhost", 5555);

      // 出力ストリームを取得
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      // 入力ストリームを取得
      BufferedReader in = new BufferedReader(
                              new InputStreamReader(
                              socket.getInputStream()));

      // 「Hello World」をサーバーに送る
      out.println("Hello World");
      // 読み込んだデータを表示
      System.out.println(in.readLine());

      // 入出力ストリームを閉じる
      out.close();
      in.close();
      // ソケットを閉じる
      socket.close();
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}