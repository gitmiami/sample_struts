package kihon;

import java.util.ArrayList;

public class compress1 {

	public static void main(String[] args) {


		ArrayList<String> arrX= new ArrayList<String>();
		ArrayList<String> arrY= new ArrayList<String>();

		arrX.add("999");
		arrX.add("a");
		arrX.add("b");
		arrX.add("b");
		arrX.add("b");
		arrX.add("b");
		arrX.add("b");
		arrX.add("c");
		arrX.add("c");
		arrX.add("c");
		arrX.add("c");
		arrX.add("d");
		arrX.add("d");
		arrX.add("d");


		arrY.add("");
		arrY.add("");
		arrY.add("");
		arrY.add("");
		arrY.add("");

		String h = arrX.get(1);

		int n=0;
		int p=0;

		int arrXSize = arrX.size();

		System.out.println("arrXSize :    " + arrXSize);
		System.out.println("h :    " + h);

		for(int i=1; i < arrXSize; i++){

			System.out.println("      i        豈碑ｼ�     " + i);
			System.out.println("arrX.get(i):   豈碑ｼ�     " + arrX.get(i));
			System.out.println("h:             豈碑ｼ�     " + h);
			System.out.println("               ");


			if(arrX.get(i).equals(h)){

				n = n+1;

				if(n < 4){

						p=p+1;

						arrY.add(p,h);

						System.out.println("p:    if zero   " + p);
						System.out.println("arrY: if zero   " + arrY.get(p));

				}else{

					System.out.println("  if zero   ");

					if(i==arrXSize){

						arrY.add(p-1, "*");
						arrY.add(p, String.valueOf(n));

						System.out.println("p:       if first   " + p);
						System.out.println("arrY:    if  first    " + arrY.get(p));
						System.out.println("               ");

					}else{


					}


				}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}else{


				if(n < 4){

					//縺ｪ縺ｫ繧ゅ＠縺ｪ縺�

				}else{

					arrY.add(p-1, "*");
					arrY.add(p, String.valueOf(n));

					System.out.println("p:           else secound   " + p);
					System.out.println("arrY:        else secound    " + arrY.get(p));
					System.out.println("               ");

				}

				p = p+1;
				arrY.add(p, arrX.get(i));
				h = arrX.get(i);
				n = 1;

				System.out.println("p:       last   " + p);
				System.out.println("arrY:    last    " + arrY.get(p));
				System.out.println("               ");
			}

////////////////////////////////////////////////////////////////////////////////////3/////////////////////////////////////////////////////


			System.out.println("h:  out   " + h);
			System.out.println("p:  out   " + p);
			System.out.println("n:  out   " + n);

			System.out.println("------------          " + i + "    end3    -----------------------------------");
			System.out.println("               ");





		}// for end



		for(int k=0; k<arrY.size();k++){

			System.out.println(arrY.get(k));
		}


	}

}
