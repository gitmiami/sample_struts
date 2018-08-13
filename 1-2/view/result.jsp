<%@page contentType="text/html; charset=MS932" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html locale="true" >
 <!-- 1)Beanが存在する場合の処理 -->
 <logic:present name="isCancel" >
  <bean:message key="cancel" />
 </logic:present>
 <BODY>
  <TABLE border="0">
   <TBODY>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">name</FONT></TH>
     <!-- 2)フォーム情報の取り出し -->
     <TD><bean:write name="VariousInputForm" property="name" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">password</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="password" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">etc</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="etc" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">check1</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="check1" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">check2</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="check2" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">multi1(複数選択可能)　単純な表示</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="multi1" />
     </TD>
    </TR>
    <TR>
    <TH bgcolor="#000000"><FONT color="#ffffff">multi1(複数選択可能)　ちゃんとした表示</FONT></TH>
    <!-- 3)配列を表示する方法 -->
    <TD><logic:iterate id="seleach" name="VariousInputForm" property="multi1" >
         <bean:write name="seleach" />
        </logic:iterate></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">radio1</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="radio1" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">select1</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="select1" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">select2(複数選択可能) 単純な表示</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="select2" /></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">select2(複数選択可能)　ちゃんとした表示</FONT></TH>
     <!-- 3)配列を表示する方法 -->
     <TD><logic:iterate id="seleach" name="VariousInputForm" property="select2" >
          <bean:write name="seleach" />
          </logic:iterate></TD>
    </TR>
    <TR>
     <TH bgcolor="#000000"><FONT color="#ffffff">hiddenタグの値</FONT></TH>
     <TD><bean:write name="VariousInputForm" property="hidden1" /></TD>
    </TR>
   </TBODY>
  </TABLE>
 </BODY>
</html:html>