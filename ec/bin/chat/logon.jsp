<%@ page contentType="text/html;charset=Shift_JIS"
         import="beanYama.*,java.sql.*" %>
<jsp:useBean id="objCht" class="chat.cht_bean" scope="page" />
<html>
<head>
<title>�`���b�g���[������</title>
</head>
<script language="JavaScript" src="../../bin/CheckUtil.js"></script>
<script language="JavaScript">
<!--
function chk(){
	strErr="";
	strErr+=requiredCheck(document.fm.nam.value,"���O");
	strErr+=lengthCheck(document.fm.nam.value,10,"���O");
	strErr+=requiredRadioCheck(document.fm.face,"��A�C�R��");
	strErr+=requiredCheck(document.fm.rTime.value,"���t���b�V���Ԋu");
	strErr+=lengthCheck(document.fm.rTime.value,4,"���t���b�V���Ԋu");
	strErr+=numberTypeCheck(document.fm.rTime.value,"���t���b�V���Ԋu");
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
�`���b�g���[��
<img src="icon5.gif" height="25" width="25" />
</h1>
<hr />
�m<a href="admin.jsp" target="_parent">�`���b�g���[���o�^/�폜</a>�n<br />
<form name="fm" method="POST"	action="/advanced/servlet/chat.cht_forum"
	target="down" onsubmit="return chk()">
<table bgcolor="#FFffCC">
<tr>
	<th align="right">���[�����F</th>
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
	<th align="right">���O�F</th>
	<td>
		<input type="text" name="nam" size="15" maxlength="10"
			value="guest" style="ime-mode:active;" />
	</td>
</tr><tr>
	<th align="right">��A�C�R���F</th>
	<td>
		<% for(int i=0;i<7;i++){ %>
			<input type="radio" name="face" value="<%=i%>" />
			<img src="icon<%=i%>.gif" width="25" height="25" />�@
		<% } %>
	</td>
</tr><tr>
	<th align="right">���t���b�V���Ԋu�F</th>
	<td>
		<input type="text" name="rTime" size="4" maxlength="5" value="30"
			style="ime-mode:disabled;" />�b
	</td>
</tr><tr>
	<td></td>
	<td>
		<input type="submit" value="���[������">
		<input type="reset" value="���">
	</td>
</tr>
</table>
<p><img src="tape.gif" width="500" height="30" alt="���C��" /></p>
</form>
</body>
</html>
