<%@page contentType="text/html; charset=Shift_JIS"  pageEncoding="Windows-31J"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html:html locale="true">
  <HEAD>
    <TITLE>カタログ</TITLE>
  </HEAD>

  <BODY>
   詳細を見たい商品の商品番号をクリックしてください。
   <TABLE>
    <TBODY>
     <TR>
      <TH>商品番号</TH>
      <TH>商品名</TH>
      <TH>価格</TH>
     </TR>

     <!-- 1)offset、length属性によるページ制御 -->

     <logic:iterate id="product" name="products" type="model.Product" offset="<%=(String)request.getAttribute("offset") %>" length="10" >

      <TR>
       <TD><html:link action="/CatalogDetail" paramId="id" paramName="product" paramProperty="id" >
       <bean:write name="product" property="id" /></html:link></TD>
       <TD><bean:write name="product" property="name" /></TD>
       <TD><bean:write name="product" property="price" /></TD>
      </TR>

     </logic:iterate>

    </TBODY>
   </TABLE>

   <html:form action="/CatalogPage" >

     <!-- 2)前に進むボタン、次に進むボタンの表示制御 -->
     <!-- 3)LookupDispatchActionを利用するための記述方法 -->

     <logic:greaterThan name="offset" value="0">
      <html:submit property="action" >
       <bean:message key="back" />
      </html:submit>
     </logic:greaterThan>

     <logic:lessThan name="offset" value="<%=Integer.toString(((java.util.List)session.getAttribute("products")).size() -10) %>" >
      <html:submit property="action" >
       <bean:message key="next" />
      </html:submit>
    </logic:lessThan>

    <!-- 4)hiddenタグで現在のoffsetを送信する -->
    <html:hidden property="offset" value="<%=(String)request.getAttribute("offset") %>" />

   </html:form>
  </BODY>
</html:html>
