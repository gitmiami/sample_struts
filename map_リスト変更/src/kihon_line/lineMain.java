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
		int LineC=0; //�s
		int MaxC=10;  //1�s�ɏo�͂���ő啶����;
		int MaxL=20;  //1�y�[�W�ɏo�͂���ő�s��;

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
			//1��ځ@�P�O�A2��ڂP�Q
			///////////////////////////////////////////////////////////////////////////////////

//�@EndP�����߂�
//�AEndP�܂ŉ�
//�BCurrentP�@�@StartP�@�ɒ���

			for( CurrentP=MarginP; StartP < EndP; CurrentP++){
				//////////////Line��str�����Ă���   Currentp �͂S�߂���AstartP ��1����
				Line[CurrentP] = str[StartP];
				StartP=StartP+1;
			}
			//�Ō�EOS�@�����
			Line[CurrentP] = "EOS";

			/////////// printtLine   ////////////////////////////////////////////////////////////////////////
			putLine(Line);
			/////////// printtLine   ////////////////////////////////////////////////////////////////////////

			LineC=LineC+1;     //���̍s�ǉ�

			//�y�[�W�̐���
			//�ő�s�Ȃ��
			if(LineC >= MaxL){
				//putchar("FF");    //���y�[�W
				System.out.printf("FF");
				LineC=0;
			}

			//NL ���s�Ȃ��
			//1���strapP 0 ��10�@������10
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