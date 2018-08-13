import java.net.*;
import java.io.*;

public class HelloWorldSocketServer {
  public static void main(String[] args) {
    try{
      // サーバーソケットの生成
      ServerSocket serverSocket = new ServerSocket(5555);

      System.out.println("クライアントからの接続をポート5555で待ちます");
      // クライアントからの接続を待ちます
      Socket socket = serverSocket.accept();
      System.out.println(socket.getInetAddress() + "から接続を受付ました");

      // 出力ストリームを取得
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      // 入力ストリームを取得
      BufferedReader in = new BufferedReader(
                              new InputStreamReader(
                              socket.getInputStream()));

      // 読み込んだ行をそのまま出力ストリームに書き出す
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        out.println(inputLine);
      }

      System.out.println("処理が終了したので接続を切ります");

      // 入出力ストリームを閉じる
      out.close();
      in.close();
      // ソケットを閉じる
      socket.close();
      // サーバーソケットを閉じる
      serverSocket.close();
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}