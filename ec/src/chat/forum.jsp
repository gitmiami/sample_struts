<%@ page contentType="text/html;charset=Shift_JIS" import="beanYama.*" %>
<jsp:useBean id="objCht" class="chat.cht_bean" scope="request" />
<html>
<head>
<title>チャットルーム本文</title>
<meta http-equiv="Refresh"
      content="<%=(String)session.getAttribute("rTime")%>" />
<style type="text/css">
<!--
.nam{color:<%=(String)session.getAttribute("namc") %>;
     font-size:13pt;font-weight:bold;}
.dat{color:<%=(String)session.getAttribute("timc") %>;
     font-size:9pt;}
.com{color:<%=(String)session.getAttribute("comc") %>;
     font-size:11pt;font-weight:demi-bold;}
-->
</style>
</head>
<body>
<form method="POST" action="/advanced/servlet/chat.cht_update"
	name="fm" onsubmit="return chk()">
	発言：
	<input type="text" name="comment" size="60" maxlength="255"
		style="ime-mode:active;" />
	<input type="submit" value="発言">
</form>
<hr />
<dl>
<% for(int i=0;i<objCht.getResultCount();i++){ %>
	<dt>
		<img src="/advanced/chap2/chat/icon<%=objCht.getIcon(i)%>.gif"
			height="25" width="25" />
		<span class="nam"><%=EncodeUtil.htmlEncode(objCht.getNam(i))%></span>
		（<span class="dat"><%=objCht.getDat(i)%></span>）</dt>
	<dd>
		<span class="com"><%=EncodeUtil.htmlEncode(objCht.getComment(i))%></span>
	</dd>
<% } %>
</dl>
</body>
</html>
