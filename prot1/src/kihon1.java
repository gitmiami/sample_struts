import javax.management.StringValueExp;


public class kihon1 {


	public static void main(String[] args) {

		int margin=4;
		int marginP=0;

		int currentP=0;

		int startP =0;
		int endP =0;

		//1�s�̍ő啶����
		int maxC =7;

		String eos ="z";

		String[] line= new String[10];
//		String[] strList = {"Sunday","satarday"};
		String[] strList = new String[10];
		String[] printLine = new String[10];

		endP = startP;

		//////////////////////////////strList���쐬
		int y=0;

		for(int i=0; i<5; i++){

			strList[i] = String.valueOf(y);
								//strList[i] = "a";
			y++;
			System.out.println("strList[i]  ---------------   " +  strList[i]);
		}
		//////////////////////////////

		//////////////////////////////margin���쐬
		for(marginP=0; marginP < margin; marginP++){
				line[marginP] = " ";
		}

		//////////////////////////////endP�擾
		while(strList[endP] != eos &&  strList[endP] != null  && endP< (startP + maxC)){
			System.out.println("endP  ---------------   " +  endP);
			endP++;
		}

		System.out.println("endP endP ---------------   " +  endP);

		//	///////////////////////////line��strList��ǉ�

		for(currentP=margin; startP<endP; currentP++){
			line[currentP]=strList[startP];
			startP++;
		}

		//EOS�ݒ�
		line[currentP]="z";

		//////////////////////////////�@�@printLine���쐬
		pLine(currentP,printLine, line);


//		for(marginP=0; marginP < margin; marginP++){
//
//			line[currentP] = strList[startP];
//			startP++;
//�@
//		}

		System.out.println("aa");

	}


		private static void pLine(int currentP,String[] printLine, String[] line){
			for(currentP=0; line[currentP] != "z"; currentP++){
				printLine[currentP]=line[currentP];
			}

		}


}
