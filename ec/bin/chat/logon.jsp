<%@ page contentType="text/html;charset=Shift_JIS"
         import="beanYama.*,java.sql.*" %>
<jsp:useBean id="objCht" class="chat.cht_bean" scope="page" />
<html>
<head>
<title>チャットルーム入室</title>
</head>
<script language="JavaScript" src="../../bin/CheckUtil.js"></script>
<script language="JavaScript">
<!--
function chk(){
	strErr="";
	strErr+=requiredCheck(document.fm.nam.value,"名前");
	strErr+=lengthCheck(document.fm.nam.value,10,"名前");
	strErr+=requiredRadioCheck(document.fm.face,"顔アイコン");
	strErr+=requiredCheck(document.fm.rTime.value,"リフレッシュ間隔");
	strErr+=lengthCheck(document.fm.rTime.value,4,"リフレッシュ間隔");
	strErr+=numberTypeCheck(document.fm.rTime.value,"リフレッシュ間隔");
	if(strErr==""){
		return true;
	}else{
		window.alert(strErr);
		return false;
	}
}
//-->
</script>
<body>
<h1>
<img src="icon1.gif" height="25" width="25" />
チャットルーム
<img src="icon5.gif" height="25" width="25" />
</h1>
<hr />
［<a href="admin.jsp" target="_parent">チャットルーム登録/削除</a>］<br />
<form name="fm" method="POST"	action="/advanced/servlet/chat.cht_forum"
	target="down" onsubmit="return chk()">
<table bgcolor="#FFffCC">
<tr>
	<th align="right">ルーム名：</th>
	<td><select name="frmNam">
		<%
		ResultSet rs=objCht.getRoomInfo();
		while(rs.next()){
			out.print("<option value='" + rs.getString("id") + "'>");
			out.print(EncodeUtil.htmlEncode(rs.getString("nam"))+ "</option>");
		}
		rs.close();
		%>
	</select></td>
</tr><tr>
	<th align="right">名前：</th>
	<td>
		<input type="text" name="nam" size="15" maxlength="10"
			value="guest" style="ime-mode:active;" />
	</td>
</tr><tr>
	<th align="right">顔アイコン：</th>
	<td>
		<% for(int i=0;i<7;i++){ %>
			<input type="radio" name="face" value="<%=i%>" />
			<img src="icon<%=i%>.gif" width="25" height="25" />　
		<% } %>
	</td>
</tr><tr>
	<th align="right">リフレッシュ間隔：</th>
	<td>
		<input type="text" name="rTime" size="4" maxlength="5" value="30"
			style="ime-mode:disabled;" />秒
	</td>
</tr><tr>
	<td></td>
	<td>
		<input type="submit" value="ルーム入室">
		<input type="reset" value="取消">
	</td>
</tr>
</table>
<p><img src="tape.gif" width="500" height="30" alt="ライン" /></p>
</form>
</body>
</html>
