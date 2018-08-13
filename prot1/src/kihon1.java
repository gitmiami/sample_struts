import javax.management.StringValueExp;


public class kihon1 {


	public static void main(String[] args) {

		int margin=4;
		int marginP=0;

		int currentP=0;

		int startP =0;
		int endP =0;

		//1行の最大文字数
		int maxC =7;

		String eos ="z";

		String[] line= new String[10];
//		String[] strList = {"Sunday","satarday"};
		String[] strList = new String[10];
		String[] printLine = new String[10];

		endP = startP;

		//////////////////////////////strListを作成
		int y=0;

		for(int i=0; i<5; i++){

			strList[i] = String.valueOf(y);
								//strList[i] = "a";
			y++;
			System.out.println("strList[i]  ---------------   " +  strList[i]);
		}
		//////////////////////////////

		//////////////////////////////marginを作成
		for(marginP=0; marginP < margin; marginP++){
				line[marginP] = " ";
		}

		//////////////////////////////endP取得
		while(strList[endP] != eos &&  strList[endP] != null  && endP< (startP + maxC)){
			System.out.println("endP  ---------------   " +  endP);
			endP++;
		}

		System.out.println("endP endP ---------------   " +  endP);

		//	///////////////////////////lineにstrListを追加

		for(currentP=margin; startP<endP; currentP++){
			line[currentP]=strList[startP];
			startP++;
		}

		//EOS設定
		line[currentP]="z";

		//////////////////////////////　　printLineを作成
		pLine(currentP,printLine, line);


//		for(marginP=0; marginP < margin; marginP++){
//
//			line[currentP] = strList[startP];
//			startP++;
//　
//		}

		System.out.println("aa");

	}


		private static void pLine(int currentP,String[] printLine, String[] line){
			for(currentP=0; line[currentP] != "z"; currentP++){
				printLine[currentP]=line[currentP];
			}

		}


}
