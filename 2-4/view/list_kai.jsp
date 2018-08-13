<%@page contentType="text/html; charset=MS932" %>

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

  <!-- header     -->

	<H1>HeaderHeaderHeaderHeader</H1>
	<H1>パーム住設</H1><BR>
 	<BR>
 	<HR>
<!--
	  <TABLE border="2" >

	   		<TR>
		   		<TD>社名</TD><TD>パーム住設	</TD>
			</TR>
			<TR>
				<TD>代表者	</TD><TD>佐藤昭	</TD>
			<TR>
			<TR>
				<TD>設立</TD><TD>2010年6月</TD>
			<TR>
			<TR>
				<TD>業務内容</TD><TD>家庭用エアコンの設置	</TD>
	   		</TR>
	  </TABLE>

 -->

<nav>
<ul>
	<li class="menu-item"><a href="index.html">ホーム</a>
	<li><a href="compinfo.html">会社概要</a>
	<li class="menu-item"><a href="gyomu.html">業務内容</a>
	<li class="menu-item"><a href="toiawase.html">お問合せ</a>

</ul></nav>

<a href="index.html">TTTTTTT</a>          <a href="index.html">yyyyyyyyy</a>                 <a href="index.html">xxxxxxxxx</a>

<dl>
	<dt>社名</dt>
	<dd>パーム住設</dd>
</dl>
<dl>
	<dt>代表者</dt>
	<dd>佐藤昭</dd>
</dl>
<dl>
	<dt>所在地</dt>
	<dd>千葉県山武市板中新田</dd>
</dl>
<dl>
	<dt>設立</dt>
	<dd>2014年</dd>
</dl>


<dl>
	<dt>業務内容</dt>
	<dd>家庭用エアコンの設置</dd>
	<dd>鉄の溶接、溶断作業</dd>
	<dd>大工工事</dd>
	<dd>土木工事</dd>
	<dd>建築工事</dd>
	<dd></dd>
</dl>

<dl>
	<dt>お問合せ</dt>
	<dd>電子メールにて承ります。</dd>
	<dd>お名前、電話番号、お問合せ内容を明記の上お送りください。</dd>
	<dd>E-mail : adiosmike@gmail.com</dd>

</dl>





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
  <BR>
  <HR>
	Copyright (C) パーム住設 2016


</BODY>
</HTML>