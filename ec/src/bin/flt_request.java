package bin;

import bin.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class flt_request implements Filter {
	private FilterConfig config=null;
	public void init(FilterConfig conf){
		this.config=conf;
	}
	public void destroy(){}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		request.setCharacterEncoding("JISAutoDetect");
		String   strNam=null;
		String[] aryVal=null;
		Enumeration objEnm=request.getParameterNames();
		while(objEnm.hasMoreElements()){
			StringBuffer objVal=new StringBuffer();
			strNam=(String)(objEnm.nextElement());
			aryVal=request.getParameterValues(strNam);
			for(int i=0;i<aryVal.length;i++){
				objVal.append(EncodeUtil.sqlEscape(aryVal[i]));
				objVal.append(i<aryVal.length-1 ? "," : "");
			}
			request.setAttribute(strNam,objVal.toString());
		}
		chain.doFilter(request,response);
	}
}
