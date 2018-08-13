//オーバーライドのTEST


//既存にあるクラス
class superClass8 {
  //(1)オーバーライドされるメソッド
  void methodA(int i) {
    int x = i * 200;

    System.out.println("Oya  method A   →  " + x);
  }

  void methodB(int i) {
	    int x = i * 300;

	    System.out.println("Oya method B    →  " + x);
	  }


}


//下記クラスを新規に作り改修する
class subExClass8 extends superClass8 {
  //(2)オーバーライドするメソッド
  void methodA(int i) {
    int x = i * 10;
    System.out.println("Sub      →" +  x);
  }


  public static void main(String[] args) {

	subExClass8 objectSub = new subExClass8();  //(3)

	superClass8 objectOya = new superClass8();  //(3)

	superClass8 oyaSub = new superClass8();  //(3)

    objectSub.methodA(10);  //(4)
    objectSub.methodB(10);  //(4)

    System.out.println("　　　　　　　　　　　");
    System.out.println("↓↓↓↓↓↓↓　　　　親クラス　指導　　　　↓↓↓↓↓↓↓");
    System.out.println("　　　　　　　　　　　");
    objectOya.methodA(10);

    oyaSub.methodA(10);


  }
}