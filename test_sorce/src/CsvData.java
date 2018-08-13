import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.lang.System;

public class CsvData {
    public static void main(String[] A00){
        String L00 = "busyo.csv";

        try {
            BufferedReader L01 = new BufferedReader(new FileReader(L00));
            String L02;
            while( (L02 = L01.readLine()) != null ) {
                String[] L03 = L02.split(",");
                System.out.printf("%s [政治:%3s 軍事:%3s 智謀:%3s 野望:%3s]%n",
                        L03[0], L03[1], L03[2], L03[3], L03[4]);
            }
            L01.close();
        } catch(FileNotFoundException L04) {
            System.out.println(L00 + "が見つかりませでした。");
        } catch(IOException L05) {
            System.out.println(L00 + "を読み込めませんでした。");
        }
    }
}
