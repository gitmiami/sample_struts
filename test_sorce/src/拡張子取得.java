
public class 拡張子取得 {

		public static void main(String[] args){

			String stG = "";
			stG = getExetention("cccccccccccccccccccc.vbvb");

			System.out.println("disp                " + stG);


		}

		/**
	     * 指定されたファイル名から拡張子を取得して返します。
	     *
	     * @param   fileName    ファイル名
	     * @return  拡張子
	     */
	    public static String getExetention(String fileName) {

	        if (fileName != null) {
	            int index = fileName.lastIndexOf('.');
	            if (index != -1 && index < fileName.length()) {
	                return fileName.substring(index + 1);
	            }
	        }
	        return "";
	    }
}

