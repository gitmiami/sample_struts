package tagLib;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class RichInput extends TagSupport {
	private String name;
	private String type;
	private int size;
	private int cols;
	private int rows;
	private String dataSource;
	private String dataSourceValue;
	private int maxLength;
	private String imeMode;
	private boolean multi=false;
	private boolean requiredCheck=false;
	private String rangeCheck;
	private String zenHanCheck;
	private boolean numberTypeCheck=false;
	private boolean dateTypeCheck=false;
	private int lengthCheck=0;
	private String regexCheck;
	private String compareCheck;
	private String duplicateCheck;
	private String error;
	public int doStartTag() throws JspException {
		int i;
		String reqNam=null;
		Object[] aryVal1=null,aryVal2=null;
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		JspWriter out=pageContext.getOut();
		if(request.getAttribute(name)!=null){
			reqNam=(String)request.getAttribute(name);
		}
		if(dataSource!=null && request.getAttribute(dataSource)!=null){
			aryVal1=(Object[])request.getAttribute(dataSource);
			aryVal2=(Object[])request.getAttribute(dataSourceValue);
		}
		try {
			switch (type.charAt(0)) {
				case 't' :
					out.print("<input type='text' ");
					out.print("name='" + name + "' ");
					out.print("size='" + size + "' ");
					out.print("maxlength='" + maxLength + "' ");
					out.print("style='ime-mode:" + imeMode + "' ");
					out.print("value='" + (reqNam!=null ? reqNam : "") + "' />");
					out.print(System.getProperty("line.separator"));
					fncReq(out);
					fncRng(out);
					fncZenHan(out);
					fncNumType(out);
					fncDateType(out);
					fncLen(out);
					fncRegex(out);
					fncCompare(out);
					fncDuplicate(out);
					fncErr(out);
					break;
				case 'p' :
					out.print("<input type='password' ");
					out.print("name='" + name + "' ");
					out.print("size='" + size + "' ");
					out.print("maxlength='" + maxLength + "' style='ime-mode:disabled'");
					out.print(" value='" + (reqNam!=null ? reqNam : "") + "' />");
					out.print(System.getProperty("line.separator"));
					fncReq(out);
					fncLen(out);
					fncZenHan(out);
					fncErr(out);
					break;
				case 's' :
					out.print("<select name='" + name + "'>");
					if(aryVal1!=null && aryVal2!=null){
						for(i=0;i<aryVal1.length;i++){
							out.print("<option value='" + aryVal1[i] + "' ");
							if(aryVal1[i].equals(reqNam)){
								out.print("selected");
							}
							out.print(">" + aryVal2[i] + "</option>");
						}
					}
					out.print("</select>");
					fncCompare(out);
					fncErr(out);
					break;
				case 'r' :
					if(aryVal1!=null && aryVal2!=null){
						for(i=0;i<aryVal1.length;i++){
							out.print("<input type='radio' name='" + name + "' ");
							out.print("value='" + aryVal1[i] + "' ");
							if(aryVal1[i].equals(reqNam)){
								out.print("checked");
							}
							out.print(">" + aryVal2[i] + "</input>");
							if(multi){out.print("<br />");}
						}
					}
					break;
				case 'c' :
					if(aryVal1!=null && aryVal2!=null){
						for(i=0;i<aryVal1.length;i++){
							out.print("<input type='checkbox' name='" + name + "' ");
							out.print("value='" + aryVal1[i] + "' ");
							if(aryVal1[i].equals(reqNam)){
								out.print("checked");
							}
							out.print(">" + aryVal2[i] + "</input>");
							if(multi){out.print("<br />");}
						}
					}
					break;
				case 'm' :
					out.print("<textarea name='" + name + "' ");
					out.print("cols='" + cols + "' rows='" + rows + "' ");
					out.print("style='ime-mode:" + imeMode + "'>");
					out.print((reqNam!=null ? reqNam : "") + "</textarea>");
					fncReq(out);
					fncLen(out);
					fncErr(out);
					break;
				default :
					out.println("typeëÆê´ÇÃílÇ™ä‘à·Ç¡ÇƒÇ¢Ç‹Ç∑ÅF" + type);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	private void fncReq(JspWriter out){
		if(requiredCheck){
			try {
			out.print("<input type='hidden' name='" + name + "__requiredCheck' ");
			out.print("value='true' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncRng(JspWriter out){
		if(rangeCheck!=null && !rangeCheck.equals("")){
			try {
				out.print("<input type='hidden' name='" + name + "__rangeCheck' ");
				out.print("value='" + rangeCheck + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncZenHan(JspWriter out){
		if(zenHanCheck!=null && !zenHanCheck.equals("")){
			try {
				out.print("<input type='hidden' name='" + name + "__zenHanCheck' ");
				out.print("value='" + zenHanCheck + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncNumType(JspWriter out){
		if(numberTypeCheck){
			try {
				out.print("<input type='hidden' name='" + name + "__numberTypeCheck' ");
				out.print("value='true' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncDateType(JspWriter out){
		if(dateTypeCheck){
			try {
				out.print("<input type='hidden' name='" + name + "__dateTypeCheck' ");
				out.print("value='true' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncLen(JspWriter out){
		if(lengthCheck!=0){
			try {
				out.print("<input type='hidden' name='" + name + "__lengthCheck' ");
				out.print("value='" + lengthCheck + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncRegex(JspWriter out){
		if(regexCheck!=null && !regexCheck.equals("")){
			try {
				out.print("<input type='hidden' name='" + name + "__regexCheck' ");
				out.print("value='" + regexCheck + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncCompare(JspWriter out){
		if(compareCheck!=null && !compareCheck.equals("")){
			try {
				out.print("<input type='hidden' name='" + name + "__compareCheck' ");
				out.print("value='" + compareCheck + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncDuplicate(JspWriter out){
		if(duplicateCheck!=null && !duplicateCheck.equals("")){
			try {
				out.print("<input type='hidden' name='" + name + "__duplicateCheck' ");
				out.print("value='" + duplicateCheck + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void fncErr(JspWriter out){
		if(error!=null && !error.equals("")){
			try {
				out.print("<input type='hidden' name='" + name + "__error' ");
				out.print("value='" + error + "' />");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void setName(String name){this.name=name;}
	public void setType(String type){this.type=type;}
	public void setSize(int size){this.size=size;}
	public void setCols(int cols){this.cols=cols;}
	public void setRows(int rows){this.rows=rows;}
	public void setDataSource(String dataSource){this.dataSource=dataSource;}
	public void setDataSourceValue(String dataSourceValue){this.dataSourceValue=dataSourceValue;}
	public void setMaxLength(int maxLength){this.maxLength=maxLength;}
	public void setImeMode(String imeMode){this.imeMode=imeMode;}
	public void setMulti(boolean multi){this.multi=multi;}
	public void setRequiredCheck(boolean requiredCheck){this.requiredCheck=requiredCheck;}
	public void setRangeCheck(String rangeCheck){this.rangeCheck=rangeCheck;}
	public void setZenHanCheck(String zenHanCheck){this.zenHanCheck=zenHanCheck;}
	public void setNumberTypeCheck(boolean numberTypeCheck){this.numberTypeCheck=numberTypeCheck;}
	public void setDateTypeCheck(boolean dateTypeCheck){this.dateTypeCheck=dateTypeCheck;}
	public void setLengthCheck(int lengthCheck){this.lengthCheck=lengthCheck;}
	public void setRegexCheck(String regexCheck){this.regexCheck=regexCheck;}
	public void setCompareCheck(String compareCheck){this.compareCheck=compareCheck;}
	public void setDuplicateCheck(String duplicateCheck){this.duplicateCheck=duplicateCheck;}
	public void setError(String error){this.error=error;}
}
