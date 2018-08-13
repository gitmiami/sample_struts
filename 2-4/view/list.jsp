<%@page contentType="text/html; charset=MS932" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<HTML>
 <HEAD>
  <TITLE>Web日記</TITLE>


 <!-- styleはまだ動作確認ずみ-->
<style type="text/css">
	<!--
		dt  {
		  font-weight : bold;
		  padding-top : 5px;
		  padding-left : 15px;
		  padding-right : 0px;
		  padding-bottom : 5px;
		  margin-bottom : 10px;
		  border-bottom-width : 1px;
		  border-bottom-style : outset;
		  border-bottom-color : #DBDBDB;
		}

		ul{
		  margin: 0;
		  box-sizing: border-box;
		}

		nav{
		  box-sizing: border-box;
		}

		a.menu-item {
		  color : #ffffff;
		  background-color : #dc2314;
		}

	-->
</style>


 </HEAD>
 <BODY>


  <logic:iterate id="content" name="diary" scope="request">

	<br><br><br>

	  <TABLE border="2" >
	   <TR>
	   		<TD colspan="2" >
				<bean:write name="content" property="date" />
			</TD>
	   </TR>

	   <TR>
	    	<TD><bean:write name="content" property="content" /></TD>

	     <!-- 1)画像ファイルがない場合はimgタグを作成しない -->
	     <logic:notEqual name="content" property="imgFileUrl" value="" >
		    <!-- 2)初期化のしかた -->
		    <TD><img src="<%= ((model.Diary)pageContext.findAttribute("content")).getImgFileUrl() %>" /></TD>
	     </logic:notEqual>
	   </TR>

	  </TABLE>

  </logic:iterate>

  <!-- footer     -->

<p>
  <html:link action="/BackDiary">入力フォームに戻る。</html:link>

  <BR>
  <HR>
	Copyright (C) ブラボーワン


</BODY>
</HTML>