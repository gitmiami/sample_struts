
import java.io.File;

class file_test2{
  public static void main(String args[]){

    File cdirectory = new File("c:\\aa");
    File Fileobj = new File("c:\\aa\\tx3FileName.txt");

    String filelist[] = cdirectory.list();

    for (int i = 0 ; i < filelist.length ; i++){
      System.out.println(filelist[i]);
      System.out.println(filelist[i].length());
    }

    System.out.println("     directry →→→→→→→        " + cdirectory);
    System.out.println("     filename →→→→→→→        " + Fileobj);

    String aa = cdirectory;
    String bb = Fileobj.toString;



  }
}
