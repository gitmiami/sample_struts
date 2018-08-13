package bin;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;

public class EncodeUtil implements Serializable {
	public static String htmlEncode(String strVal){
		StringBuffer strResult=new StringBuffer();
		for(int i=0;i<strVal.length();i++){
			switch(strVal.charAt(i)){
				case '&' :
					strResult.append("&amp;");
					break;
				case '<' :
					strResult.append("&lt;");
					break;
				case '>' :
					strResult.append("&gt;");
					break;
				case '\t' :
					strResult.append("&nbsp;&nbsp;&nbsp;&nbsp;");
					break;
				default :
					strResult.append(strVal.charAt(i));
					break;
			}
		}
		return strResult.toString();
	}
	public static String sqlEscape(String strVal){
		StringBuffer strResult=new StringBuffer();
		for(int i=0;i<strVal.length();i++){
			switch(strVal.charAt(i)){
				case '\'' :
					strResult.append("\\\'");
					break;
				case '"' :
					strResult.append("\\\"");
					break;
				case '\\' :
					strResult.append("\\\\");
					break;
				default :
					strResult.append(strVal.charAt(i));
					break;
			}
		}
		return strResult.toString();
	}
	public static String escape(String strVal) {
		StringBuffer strResult=new StringBuffer();
		for(int i=0;i<strVal.length();i++){
			switch(strVal.charAt(i)){
				case '&' :
					strResult.append("&amp;");
					break;
				case '<' :
					strResult.append("&lt;");
					break;
				case '>' :
					strResult.append("&gt;");
					break;
				case '\t' :
					strResult.append("&nbsp;&nbsp;&nbsp;&nbsp;");
					break;
				case '\'' :
					strResult.append("\\\'");
					break;
				case '"' :
					strResult.append("\\\"");
					break;
				case '\\' :
					strResult.append("\\\\");
					break;
				default :
					strResult.append(strVal.charAt(i));
					break;
			}
		}
		return strResult.toString();
	}
	public static String formatDate(String strFmt){
		Calendar objCal=Calendar.getInstance();
		Date objDat=objCal.getTime();
		SimpleDateFormat objSFmt=new SimpleDateFormat(strFmt);
		return objSFmt.format(objDat);
	}
	public static String formatDate(String strFmt, Date dteVal){
		SimpleDateFormat objSFmt=new SimpleDateFormat(strFmt);
		return objSFmt.format(dteVal);
	}
	public static void toBlank(HttpServletRequest request,String[] key){
		for(int i=0;i<key.length;i++){
			String strTmp=(String)request.getAttribute(key[i]);
			request.setAttribute(key[i],(strTmp==null ? "" : strTmp));
		}
	}
}