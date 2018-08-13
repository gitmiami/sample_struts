<%@ page contentType="text/html;charset=Shift_JIS"
         import="beanYama.*,java.sql.*" %>
<jsp:useBean id="objEc" class="ec.ec_bean" scope="page" />
<html>
<head>
<title>電子商店街</title>
<base target="down" />
</head>
<body>
<h1 align="center">
<img src="ec.gif" height="30" width="30" />
電子商店街
<img src="ec.gif" height="30" width="30" />
</h1>
<table border="0" align="center">
<tr cellspacing="5">
<% ResultSet rs=objEc.getStore();
while(rs.next()){ %>
	<td width="120">
		<img src="<%=rs.getString("pic")%>" width="20" height="20" />
		<a href="store.jsp?stor=<%=rs.getString("id")%>">
			<%=EncodeUtil.htmlEncode(rs.getString("nam"))%></a>
	</td>
<% } %>
<td width="120">
<img src="crown.gif" width="20" height="20" />
<a href="account.jsp">お会計場</a>
<img src="crown.gif" width="20" height="20" />
</td>
</tr>
</table>
<hr />
</body>
</html>
