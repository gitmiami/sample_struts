<%@ page contentType="text/html;charset=Shift_JIS"
         import="java.io.*,java.text.*,java.sql.*" %>
<jsp:useBean id="objEc" class="ec.ec_bean" scope="page" />
<% if(request.getAttribute("sbm")==null){ %>
	<html>
	<head>
	<title>精算場</title>
	<script language="JavaScript" src="../../bin/CheckUtil.js"></script>
	<script language="JavaScript">
	<!--
	function chk(){
		strErr="";
		strErr+=requiredCheck(document.fm.nam.value,"名前");
		strErr+=lengthCheck(document.fm.nam.value,15,"名前");
		strErr+=requiredCheck(document.fm.zip.value,"郵便番号");
		strErr+=regExCheck(document.fm.zip.value,"^[0-9]{3}-[0-9]{4}$","郵便番号");
		strErr+=requiredCheck(document.fm.address.value,"住所");
		strErr+=lengthCheck(document.fm.address.value,50,"住所");
		strErr+=requiredCheck(document.fm.tel.value,"TEL");
		strErr+=HanCheck(document.fm.tel.value,"TEL");
		strErr+=lengthCheck(document.fm.tel.value,15,"TEL");
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
	<form method="POST" action="account.jsp" name="fm" onsubmit="return chk()">
	<input type="submit" name="sbm" value="決定" />
	<table border="1">
	<tr bgcolor="#00ccff">
		<th>商品名</th><th>単価</th><th>個数</th><th>小計</th>
	</tr>
	<%
	int cnt=1;
	int sum=0;
	boolean flag=false;
	DecimalFormat objFmt=new DecimalFormat("###,###,##0 円");
	ResultSet rs=objEc.getProduct();
	while(rs.next()){
		String strVal=(String)session.getAttribute(rs.getString("code"));
		if(strVal!=null && !strVal.equals("") && !strVal.equals("0")){
	%>
			<tr bgcolor="#ffff99">
			<td>
				<%=rs.getString("nam")%>
				<input type="hidden" name="code<%=cnt%>"
					value="<%=rs.getString("code")%>" />
				<input type="hidden" name="num<%=cnt%>" value="<%=strVal%>" />
			</td>
			<td align="right"><%=objFmt.format(rs.getInt("pric"))%></td>
			<td align="right"><%=strVal%>個</td>
			<td align="right">
				<%=objFmt.format(rs.getInt("pric") * Integer.parseInt(strVal))%>
			</td>
			</tr>
	<%
			sum+=rs.getInt("pric") * Integer.parseInt(strVal);
			cnt++;
		}
	}
	%>
	<input type="hidden" name="cnt" value="<%=cnt-1%>" />
	<tr>
		<th colspan="3" align="right" bgcolor="#00ccff">合計</th>
		<td bgcolor="#ffff99" align="right"><%=objFmt.format(sum)%></td>
	</tr>
	</table>
	<hr />
	<table border="0">
		<tr>
			<th align="right">名前：</th>
			<td><input type="text" name="nam" size="15" maxlength="15"
				style="ime-mode:active;"/></td>
		</tr><tr>
			<th align="right">郵便番号：</th>
			<td><input type="text" name="zip" size="10" maxlength="8"
				style="ime-mode:disabled;" /></td>
		</tr><tr>
			<th align="right">住所：</th>
			<td><input type="text" name="address" size="60" maxlength="50"
				style="ime-mode:active;" /></td>
		</tr><tr>
			<th align="right">TEL：</th>
			<td><input type="text" name="tel" size="15" maxlength="15"
				style="ime-mode:disabled;" /></td>
		</tr>
	</table>
	</form>
<%
}else{
	int intId=objEc.setCustomer((String)request.getAttribute("nam"),(String)request.getAttribute("zip"),(String)request.getAttribute("address"),(String)request.getAttribute("tel"));
	for(int i=1;i<=Integer.parseInt(request.getParameter("cnt"));i++){
		objEc.setOrder((String)request.getAttribute("code" + i),(String)request.getAttribute("num" + i),intId);
	}
	session.invalidate();
%>
	<div align="center">毎度ありがとうございました。<br />
	またのご来店をお待ちしております。<br />
	<img src='thanks.gif' /></div>
<% } %>
</body>
</html>
