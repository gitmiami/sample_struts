<%@page contentType="text/html; charset=MS932" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html:html>
 <HEAD>
  <TITLE>Web���L</TITLE>
 </HEAD>
 <BODY>
  <H1>2-4�̃T���v�� Web���L</H1><BR>
  <html:link action="/DiaryList">���L���������ɓ��e���݂�B</html:link>

  <!-- 1�jUpload�̂��߂̃G���R�[�h�^�C�v�̒ǉ� -->
 	<html:form action="/DiaryEntry" enctype="multipart/form-data">

	  <!-- 2) ���t�̕ϊ������s�����ꍇ�̃G���[���b�Z�[�W�@-->
	<html:errors />

	   ���t(2004-09-30�̂悤�ɋL�q���Ă�������)<BR>
	   <html:text size="20" property="date" /><BR>

	   ���e<BR>
	   <html:textarea rows="10" cols="40" property="content" /><BR>

	   <!-- 3)Upload�̂��߂� html:file �^�O�̗��p���Ă��܂� -->
	   �摜�t�@�C��<html:file property="imgFile" /><BR>

	   <html:submit value="���L��������" />

	</html:form>

</BODY>
</html:html>