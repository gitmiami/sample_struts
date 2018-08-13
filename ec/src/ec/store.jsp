<%@ page contentType="text/html;charset=Shift_JIS"
         import="beanYama.*,java.text.*,java.sql.*" %>
<jsp:useBean id="objEc" class="ec.ec_bean" scope="page" />
<% if(request.getAttribute("sbm")==null){ %>
	<html>
	<head>
	<title>商品選択</title>
	<script language="JavaScript" src="../../bin/CheckUtil.js"></script>
	<script language="JavaScript">
	<!--
	function chk(part){
		strErr="";
		strErr+=rangeCheck(part.value,999,0,"個数");
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
	<form method="POST" action="store.jsp">
	<input type="submit" name="sbm" value="カゴに入れる" />
	<input type="reset" value="やめる" />
	<table border="0" align="center" width="600" cellspacing="15">
	<tr>
	<%
	int cnt=1;
	ResultSet rs=objEc.getProduct(request.getParameter("stor"));
	while(rs.next()){
		DecimalFormat objFmt=new DecimalFormat("###,###,#00");
	%>
		<td valign="top">
		<table border="1" height="180">
		<tr>
		<td valign="top">
		<% if(rs.getString("pic")!=null && !rs.getString("pic").equals("")){ %>
			<img src="./img/<%=rs.getString("pic")%>"
				alt='商品イメージ' height='70' width='50' />
		<% }else{ %>
			<img src='welcome.gif' alt='商品イメージ（画像なし）'
				width='50' height='50' />
		<% } %>
		</td>
		<td valign="top" bgcolor="#ffffee">
		<div style="font-weight:bold;">
			<%=EncodeUtil.htmlEncode(rs.getString("nam"))%></div>
		<div align="right">（<%=objFmt.format(rs.getInt("pric"))%>円）</div>
		<hr />
		<%=rs.getString("info")%><br />
		<div align="right">
		<%
		String strVal=(String)session.getAttribute(rs.getString("code"));
		if(strVal==null || strVal.equals("")){strVal="0";}
		%>
		<input type="text" name="num<%=cnt%>" value="<%=strVal%>"
			size="4" maxlength="3" style="text-align:right;ime-mode:disabled;"
			onchange="return chk(this)" />個</div>
		<input type="hidden" name="code<%=cnt%>"
			value="<%=rs.getString("code")%>" />
		</dl>
		</td></tr>
		</table>
		</td>
	<%
		if(cnt % 3 == 0){out.println("</tr><tr>");}
		cnt++;
	}
	%>
	<input type="hidden" name="cnt" value="<%=cnt-1%>" />
	</table>
<%
}else{
	for(int i=1;i<=Integer.parseInt(request.getParameter("cnt"));i++){
		String strNum=request.getParameter("num"  + i);
		String strCod=request.getParameter("code" + i);
		if(strNum!=null){session.setAttribute(strCod,strNum);}
	}
	response.sendRedirect("blank.html");
}
%>
</form>
</body>
</html>
