<%@page contentType="text/html; charset=Shift_JIS"  pageEncoding="Windows-31J"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html:html locale="true">
  <HEAD>
    <TITLE>�J�^���O</TITLE>
  </HEAD>

  <BODY>
   �ڍׂ����������i�̏��i�ԍ����N���b�N���Ă��������B
   <TABLE>
    <TBODY>
     <TR>
      <TH>���i�ԍ�</TH>
      <TH>���i��</TH>
      <TH>���i</TH>
     </TR>

     <!-- 1)offset�Alength�����ɂ��y�[�W���� -->

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

     <!-- 2)�O�ɐi�ރ{�^���A���ɐi�ރ{�^���̕\������ -->
     <!-- 3)LookupDispatchAction�𗘗p���邽�߂̋L�q���@ -->

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

    <!-- 4)hidden�^�O�Ō��݂�offset�𑗐M���� -->
    <html:hidden property="offset" value="<%=(String)request.getAttribute("offset") %>" />

   </html:form>
  </BODY>
</html:html>
