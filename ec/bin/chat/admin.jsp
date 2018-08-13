<%@ page contentType="text/html;charset=Shift_JIS"
         import="beanYama.*,java.sql.*" %>
<jsp:useBean id="objCht" class="chat.cht_bean" scope="page" />
<html>
<head>
<title>チャットシステム</title>
<script language="JavaScript" src="../../bin/CheckUtil.js"></script>
<script language="JavaScript">
<!--
function chg(){
	namC.style.color=document.fm1.namI.value;
	timC.style.color=document.fm1.timI.value;
	comC.style.color=document.fm1.comI.value;
}
function chk_sbm(){
	strErr="";
	strErr+=requiredCheck(document.fm1.nam.value,"ルーム名");
	strErr+=lengthCheck(document.fm1.nam.value,25,"ルーム名");
	strErr+=requiredCheck(document.fm1.passwd.value,"パスワード");
	strErr+=lengthCheck(document.fm1.passwd.value,10,"パスワード");
	strErr+=HanCheck(document.fm1.passwd.value,"パスワード");
	strErr+=requiredCheck(document.fm1.namI.value,"名前文字色");
	strErr+=regExCheck(document.fm1.namI.value,"^#[a-fA-F0-9]{6}$","名前文字色");
	strErr+=requiredCheck(document.fm1.timI.value,"時間文字色");
	strErr+=regExCheck(document.fm1.timI.value,"^#[a-fA-F0-9]{6}$","時間文字色");
	strErr+=requiredCheck(document.fm1.namI.value,"本文文字色");
	strErr+=regExCheck(document.fm1.comI.value,"^#[a-fA-F0-9]{6}$","本文文字色");
	if(strErr==""){
		return true;
	}else{
		window.alert(strErr);
		return false;
	}
}
function chk_updel(){
	strErr="";
	strErr+=requiredCheck(document.fm2.passwd.value,"パスワード");
	strErr+=lengthCheck(document.fm2.passwd.value,10,"パスワード");
	strErr+=HanCheck(document.fm2.passwd.value,"パスワード");
	if(strErr==""){
		return true;
	}else{
		window.alert(strErr);
		return false;
	}
}
//-->
</script>
</head>
<body>
<h1>
<img src="icon1.gif" height="25" width="25" />
チャットシステム（管理者用）
<img src="icon5.gif" height="25" width="25" />
</h1>
<hr />
<form method="POST" action="/advanced/servlet/chat.cht_create_del"
	name="fm1" onsubmit="return chk_sbm()">
<table hspace="15">
<caption align="left" valign="top"><h2>新規ルーム登録</h2></caption>
<tr>
	<td align="right">ルーム名：</td>
	<td><input type="text" name="nam" size="25" maxlength="25"
				style="ime-mode:active;" /></td>
</tr>
<tr>
	<td align="right">パスワード：</td>
	<td><input type="password" name="passwd" size="15" maxlength="20"
				style="ime-mode:disabled;" /></td>
</tr>
<tr>
	<td rowspan=2 valign="top" align="right">文字色：</td></tr>
	<td>名前：
			<input type="text" name="namI" size="9" maxlength="7" value="#191970"
				style="ime-mode:disabled;" onchange="return chg()" /><br />
			時間：
			<input type="text" name="timI" size="9" maxlength="7" value="#DB7093"
				style="ime-mode:disabled;" onchange="return chg()" /><br />
			本文：
			<input type="text" name="comI" size="9" maxlength="7" value="#556B2F"
				style="ime-mode:disabled;" onchange="return chg()" /><br />
			</td>
</tr>
<tr><td align="center">
	<input type="submit" name="ins" value="ルーム登録">
</td></tr>
</table>
<dl>
<dt>【文字色表示例】
<dt><span id="namC"
			style="color:#191970;font-size:13pt;font-weight:bold;">山本晃子</span>
		<span id="timC" style="color:#DB7093;font-size:9pt;">
			(<%="2002年12月4日 12:35:12" %>)</span></dt>
<dd id="comC" style="color:#556B2F;font-size:11pt;font-weight:demi-bold;">
		今日も夜勤、明日も夜勤、明後日も明々後日も...（T T）</dd>
</dl>
</form>
<hr width="60%" />
<form method="POST" action="/advanced/servlet/chat.cht_create_del"
	name="fm2" onsubmit="return chk_updel()">
<table border="0">
<caption align="left" valign="top"><h2>既存ルーム削除</h2></caption>
<tr>
	<td align="right">ルーム名：</td>
		<td><select name="nam">
			<%
			ResultSet rs=objCht.getRoomInfo();
			while(rs.next()){
				out.print("<option value='" + rs.getString("id") + "'>");
				out.print(EncodeUtil.htmlEncode(rs.getString("nam")) + "</option>");
			}
			rs.close();
			%>
		</select></td>
</tr>
<tr>
	<td align="right">パスワード：</td>
	<td><input type="password" name="passwd" size="15" maxlength="10"
		style="ime-mode:disabled;" /></td>
</tr>
<tr><td><input type="submit" name="del" value="ルーム削除" /></td></tr>
</table>
</form>
<% if(request.getParameter("flag")!=null && !(request.getParameter("flag").equals(""))) { %>
	<script language="JavaScript">
	window.alert("削除用のパスワードが間違っています");
	</script>
<% } %>
</body>
</html>
