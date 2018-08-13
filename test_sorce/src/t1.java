import java.util.StringTokenizer;


public class t1 {

		public static void main(String[] args){
			StringTokenizer st =
				new StringTokenizer("abc,def,ghi jkl,mno,", ",");
			while(st.hasMoreTokens()){
				System.out.println(st.nextToken());
			}
		}


}
