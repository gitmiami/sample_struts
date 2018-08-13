package bin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ErrorDisplay extends TagSupport {
	private String display;
	private boolean terminate=false;
	public int doStartTag() throws JspException {
		HttpServletRequest request=(HttpServletRequest)(pageContext.getRequest());
		String strErr=(String)(request.getAttribute("samples.error.message"));
		if(strErr!=null && !strErr.equals("")){
			JspWriter out=pageContext.getOut();
			try {
				switch (display.charAt(0)){
					case 'D' :
						strErr=strErr.replaceAll(System.getProperty("line.separator"),"\\\\n\\\\r");
						out.println("<script language='JavaScript'><!--");
						out.println("window.alert('" + strErr + "');");
						out.println("//--></script>");
						break;
					case 'T' :
						out.println("<form>");
						out.println("<textarea cols='75' rows='7'>" + strErr + "</textarea>");
						out.println("</form>");
						break;
					default:
						strErr=strErr.replaceAll(System.getProperty("line.separator"),"<br />");
						out.println("<div>" + strErr + "</div>");
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JspException {
		HttpServletRequest request=(HttpServletRequest)(pageContext.getRequest());
		String strErr=(String)(request.getAttribute("samples.error.message"));
		if(strErr!=null && !strErr.equals("")){
			if(terminate){
				return SKIP_PAGE;
			}else{
				return EVAL_PAGE;
			}
		}else{
			return EVAL_PAGE;
		}
	}
	public void setDisplay(String display){this.display=display;}
	public void setTerminate(boolean terminate){this.terminate=terminate;}
}
