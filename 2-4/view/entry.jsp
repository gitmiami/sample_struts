<%@page contentType="text/html; charset=MS932" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html:html>
 <HEAD>
  <TITLE>Web日記</TITLE>
 </HEAD>
 <BODY>
  <H1>2-4のサンプル Web日記</H1><BR>
  <html:link action="/DiaryList">日記を書かずに内容をみる。</html:link>

  <!-- 1）Uploadのためのエンコードタイプの追加 -->
 	<html:form action="/DiaryEntry" enctype="multipart/form-data">

	  <!-- 2) 日付の変換が失敗した場合のエラーメッセージ　-->
	<html:errors />

	   日付(2004-09-30のように記述してください)<BR>
	   <html:text size="20" property="date" /><BR>

	   内容<BR>
	   <html:textarea rows="10" cols="40" property="content" /><BR>

	   <!-- 3)Uploadのために html:file タグの利用しています -->
	   画像ファイル<html:file property="imgFile" /><BR>

	   <html:submit value="日記書き込み" />

	</html:form>

</BODY>
</html:html>