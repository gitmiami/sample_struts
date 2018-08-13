package kihon_line;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class lineMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String Line[] = new String[101];

		int StartP=0;
		int LineC=0; //行
		int MaxC=10;  //1行に出力する最大文字列;
		int MaxL=20;  //1ページに出力する最大行数;

		int MarginP;
		int CurrentP;
		int EndP=0;

		String str[] = new String[2000];
		str[0]="a";
		str[1]="a";
		str[2]="a";
		str[3]="b";
		str[4]="b";
		str[5]="NL";
		str[6]="c";
		str[7]="c";
		str[8]="d";
		str[9]="d";
		str[10]="d";
		str[11]="d";
		str[12]="EOS";

		int Margin=4;

		lineMain obj =new lineMain();

////////////MarginP///////////////////////////////////////////////////////////////////////

		for(MarginP=0; MarginP< Margin; MarginP++){
			Line[MarginP] = " ";
		}
		System.out.printf("    Line[MarginP]     %s       %n      ", Line);

		///////////////////////////////////////////////////////////////////////////////////
		while(str[StartP] != ("EOS")){

			//////       GetPosition              ////////////////////////////////////////////////
			EndP = obj.Getposition(str, StartP, MaxC,  EndP);
			//1回目　１０、2回目１２
			///////////////////////////////////////////////////////////////////////////////////

//①EndPを求める
//②EndPまで回す
//③CurrentP　　StartP　に注意

			for( CurrentP=MarginP; StartP < EndP; CurrentP++){
				//////////////Lineにstrを入れている   Currentp は４つめから、startP は1から
				Line[CurrentP] = str[StartP];
				StartP=StartP+1;
			}
			//最後EOS　入れる
			Line[CurrentP] = "EOS";

			/////////// printtLine   ////////////////////////////////////////////////////////////////////////
			putLine(Line);
			/////////// printtLine   ////////////////////////////////////////////////////////////////////////

			LineC=LineC+1;     //次の行追加

			//ページの制御
			//最大行ならば
			if(LineC >= MaxL){
				//putchar("FF");    //改ページ
				System.out.printf("FF");
				LineC=0;
			}

			//NL 改行ならば
			//1回目strapP 0 →10　ここで10
			if(str[StartP] =="NL"){
				StartP = StartP+1;
			}
	}
}

	 int Getposition(String[] str,int StartP, int MaxC, int EndP){
		EndP=StartP;
		while( str[EndP] !="EOS" && str[EndP] != null  && EndP < (StartP + MaxC) ){
			EndP=EndP+1;
		}
		return EndP;
	}

	 static void  putLine(String[] Line){

			for(int CurrentP=0; Line[CurrentP] != "EOS"; CurrentP++ ){
				System.out.println("       putLine          " + Line[CurrentP]);
			}
			System.out.println("         last      -- NL --");
		}


}