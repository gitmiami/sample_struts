package bin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class Form extends TagSupport {
	private String processFile;
	private String originalFile;
	private String queryString;
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		try {
			out.print("<form method='POST' ");
			out.print("action='" + request.getContextPath());
			out.print("/servlet/beanYama.CommonCheck?PROCESS__FILE=" + processFile);
			out.print("&ORIGINAL__FILE=" + originalFile);
			out.print("&" + (queryString!=null ? queryString : "") + "'>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag() throws JspException {
		JspWriter out=pageContext.getOut();
		try {
			out.print("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	public void setProcessFile(String processFile){this.processFile=processFile;}
	public void setOriginalFile(String originalFile){this.originalFile=originalFile;}
	public void setQueryString(String queryString){this.queryString=queryString;}
}
