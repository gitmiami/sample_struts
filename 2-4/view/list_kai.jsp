<%@page contentType="text/html; charset=MS932" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<HTML>
 <HEAD>
  <TITLE>Web���L</TITLE>


 <!-- style�͂܂�����m�F����-->
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
	<H1>�p�[���Z��</H1><BR>
 	<BR>
 	<HR>
<!--
	  <TABLE border="2" >

	   		<TR>
		   		<TD>�Ж�</TD><TD>�p�[���Z��	</TD>
			</TR>
			<TR>
				<TD>��\��	</TD><TD>������	</TD>
			<TR>
			<TR>
				<TD>�ݗ�</TD><TD>2010�N6��</TD>
			<TR>
			<TR>
				<TD>�Ɩ����e</TD><TD>�ƒ�p�G�A�R���̐ݒu	</TD>
	   		</TR>
	  </TABLE>

 -->

<nav>
<ul>
	<li class="menu-item"><a href="index.html">�z�[��</a>
	<li><a href="compinfo.html">��ЊT�v</a>
	<li class="menu-item"><a href="gyomu.html">�Ɩ����e</a>
	<li class="menu-item"><a href="toiawase.html">���⍇��</a>

</ul></nav>

<a href="index.html">TTTTTTT</a>          <a href="index.html">yyyyyyyyy</a>                 <a href="index.html">xxxxxxxxx</a>

<dl>
	<dt>�Ж�</dt>
	<dd>�p�[���Z��</dd>
</dl>
<dl>
	<dt>��\��</dt>
	<dd>������</dd>
</dl>
<dl>
	<dt>���ݒn</dt>
	<dd>��t���R���s���V�c</dd>
</dl>
<dl>
	<dt>�ݗ�</dt>
	<dd>2014�N</dd>
</dl>


<dl>
	<dt>�Ɩ����e</dt>
	<dd>�ƒ�p�G�A�R���̐ݒu</dd>
	<dd>�S�̗n�ځA�n�f���</dd>
	<dd>��H�H��</dd>
	<dd>�y�؍H��</dd>
	<dd>���z�H��</dd>
	<dd></dd>
</dl>

<dl>
	<dt>���⍇��</dt>
	<dd>�d�q���[���ɂď���܂��B</dd>
	<dd>�����O�A�d�b�ԍ��A���⍇�����e�𖾋L�̏エ���肭�������B</dd>
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

	     <!-- 1)�摜�t�@�C�����Ȃ��ꍇ��img�^�O���쐬���Ȃ� -->
	     <logic:notEqual name="content" property="imgFileUrl" value="" >
		    <!-- 2)�������̂����� -->
		    <TD><img src="<%= ((model.Diary)pageContext.findAttribute("content")).getImgFileUrl() %>" /></TD>
	     </logic:notEqual>
	   </TR>

	  </TABLE>

  </logic:iterate>

  <!-- footer     -->
  <BR>
  <HR>
	Copyright (C) �p�[���Z�� 2016


</BODY>
</HTML>