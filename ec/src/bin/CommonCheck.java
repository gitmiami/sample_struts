package bin;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CommonCheck extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		String strErr1=null,strErr2=null;
		StringBuffer objStr=new StringBuffer();
		Enumeration objEnm=request.getParameterNames();
		while(objEnm.hasMoreElements()){
			String strNam=(String)(objEnm.nextElement());
			if(strNam.indexOf("__")==-1){
				String strVal=request.getParameter(strNam);
				String strTyp=request.getParameter(strNam + "__type");
				String strReq=request.getParameter(strNam + "__requiredCheck");
				String strRng=request.getParameter(strNam + "__rangeCheck");
				String strZen=request.getParameter(strNam + "__zenHanCheck");
				String strNum=request.getParameter(strNam + "__numberTypeCheck");
				String strDat=request.getParameter(strNam + "__dateTypeCheck");
				String strLen=request.getParameter(strNam + "__lengthCheck");
				String strReg=request.getParameter(strNam + "__regexCheck");
				String strCmp=request.getParameter(request.getParameter(strNam + "__compareCheck")!=null ? request.getParameter(strNam + "__compareCheck") : "");
				String strDup=request.getParameter(strNam + "__duplicateCheck");
				String strErr=request.getParameter(strNam + "__error");
				if(strErr!=null){
					StringTokenizer objStk=new StringTokenizer(strErr,",");
					if(objStk.hasMoreElements()){strErr1=(String)(objStk.nextElement());}
					if(objStk.hasMoreElements()){strErr2=(String)(objStk.nextElement());}
				}
				if(strReq!=null && strReq.equals("true")){
					objStr.append(CheckUtil.requiredCheck(strVal,strErr));
				}
				if(strRng!=null){
					StringTokenizer objTkn=new StringTokenizer(strRng,",");
					int intMax=Integer.parseInt(((String)objTkn.nextElement()));
					int intMin=Integer.parseInt(((String)objTkn.nextElement()));
					objStr.append(CheckUtil.rangeCheck(strVal,intMax,intMin,strErr));
				}
				if(strZen!=null){
					switch(strZen.charAt(0)){
						case 'Z' :
							objStr.append(CheckUtil.ZenCheck(strVal,strErr1));
							break;
						case 'H' :
							objStr.append(CheckUtil.HanCheck(strVal,strErr1));
							break;
					}
				}
				if(strNum!=null && strNum.equals("true")){
					objStr.append(CheckUtil.numberTypeCheck(strVal,strErr1));
				}
				if(strDat!=null && strDat.equals("true")){
					objStr.append(CheckUtil.dateTypeCheck(strVal,strErr1));
				}
				if(strLen!=null && !strLen.equals("")){
					objStr.append(CheckUtil.lengthCheck(strVal,Integer.parseInt(strLen),strErr1));
				}
				if(strReg!=null && !strReg.equals("")){
					objStr.append(CheckUtil.regExCheck(strVal,strReg,strErr1));
				}
				if(strCmp!=null && !strCmp.equals("")){
					objStr.append(CheckUtil.compareCheck(strVal,strCmp,strErr1,strErr2));
				}
				if(strDup!=null && !strDup.equals("")){
					StringTokenizer objStk=new StringTokenizer(strDup,",");
					strDup="SELECT * FROM " + objStk.nextElement() + " WHERE " + objStk.nextElement() + "='" + strVal + "'";
					objStr.append(CheckUtil.duplicateCheck(strDup,strErr1));
				}
				request.setAttribute("samples.error.message",objStr.toString());
			}
		}
		if(request.getAttribute("samples.error.message").equals("")){
			getServletConfig().getServletContext().getRequestDispatcher(request.getParameter("PROCESS__FILE")).forward(request,response);
		}else{
			getServletConfig().getServletContext().getRequestDispatcher(request.getParameter("ORIGINAL__FILE")).forward(request,response);
		}
	}
}