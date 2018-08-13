<%@page contentType="text/html; charset=MS932" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html locale="true" >
 <BODY>
  <H1>1-2のサンプル</H1>
  <html:form action="/VariousInput" >
    入力部品名（）の中は属性名<HR>
  <TABLE border="0" >
   <TBODY>
    <TR>
     <TD>
      <TABLE border="1" >
       <TBODY>
        <TR>
         <TH>テキストボックス(name)</TH>
         <TD><html:text property="name" /></TD>
        </TR>
        <TR>
         <TH>パスワード(password)</TH>
         <!-- 1）入力されたパスワードを隠蔽する -->
         <TD><html:password property="password" redisplay="false" /></TD>
        </TR>
        <TR>
         <TH>テキストエリア(etc)</TH>
         <TD><html:textarea property="etc" /></TD>
        </TR>
        <TR>
         <TH>チェックボックス　デフォルトオフ（check1) </TH>
         <TD><html:checkbox property="check1" />チェック1</TD>
        </TR>
        <TR>
         <!-- 2）デフォルト値を設定する　-->
         <TH>チェックボックス　デフォルトオン（check2） </TH>
         <TD><html:checkbox property="check2" value="on" />チェック2</TD>
        </TR>
        <TR>
         <TH rowspan="2" >マルチボックス(multi1)　同じmulti1で複数の選択をサポート</TH>
         <TD><html:multibox property="multi1" value="Check1" />チェック1</TD>
        </TR>
         <!-- 3） 一まとまりとして管理する チェックボックスの例 -->
        <TR>
         <TD><html:multibox property="multi1" value="Check2"/>チェック2</TD>
        </TR>
        <TR>
         <!-- 3） 一まとまりとして管理する ラジオボタンの例 -->
         <TH rowspan="2" >ラジオボタン(radio1)　ラジオ1とラジオ2で同じradio1の属性のためどちらかしか選べない </TH>
         <TD><html:radio property="radio1" value="check1" >ラジオ1</html:radio></TD>
        </TR>
        <TR>
         <TD><html:radio property="radio1" value="check2" >ラジオ2</html:radio></TD>
        </TR>

        <TR>
         <TH>セレクト(select1)　複数選択不可 </TH>
         <TD><html:select property="select1" value="S2">
              <html:option value="S1" >セレクト1</html:option>
              <html:option value="S2" >セレクト2(デフォルト値)</html:option>
              <html:option value="S3" >セレクト3</html:option>
             </html:select>
         </TD>
        </TR>

        <TR>
         <!-- 4）複数のデータを選択できるようにする -->
         <TH>セレクト(select2)　複数選択可能 </TH>
         <TD><html:select property="select2" multiple="true" size="3" >
              <html:option value="S1" >リスト1</html:option>
              <html:option value="S2" >リスト2</html:option>
              <html:option value="S3" >リスト3</html:option>
             </html:select>
         </TD>
        </TR>
       </TBODY>
      </TABLE>
     </TD>

     <TD>
      <TABLE border="1" >
       <TBODY>
       <!-- 5）リンクを作成する -->
        <TR>
         <TH>リンクを記述するケース　1-1にLinkしています。</TH>
         <TD><html:link href="http://localhost:8080/1-1/view/Hello.jsp" >1-1へ</html:link></TD>
        </TR>
        <!--　6）入力フォーム内に不可視フィールドを作成する -->
        <html:hidden property="hidden1" value="hidden1" />
        <TR>
         <TH>単純なイメージ</TH>
         <TD><html:img page="/view/image/a002btn.gif" /></TD>
        </TR>
        <TR>
         <!-- 7）様々なボタンを表示する 通常のボタン -->
         <TH>JavaScriptなどを実行するためのbuttonタグ(noReAction)の生成、JavaScriptが実行されます</TH>
         <TD><html:button property="noReAction" onclick="alert('ボタンが押されました')" /></TD>
        </TR>
        <TR>
         <!-- 7）様々なボタンを表示する イメージボタン -->
         <TH>イメージボタン(imagebutton) 押すとSubmitと同じ効果があります。</TH>
         <TD><html:image page="/view/image/a001btn.gif" property="imagebutton" /></TD>
        </TR>
        <TR>
        <!-- 7）様々なボタンを表示する サブミットボタン -->
         <TH>Submitボタン </TH>
         <TD><html:submit /><BR>
             <html:submit value="送信" /><BR>
             <html:submit disabled="true" /><BR>
         </TD>
        </TR>
        <TR>
        　<!-- 7）様々なボタンを表示する リセットボタン -->
         <TH>Resetボタン </TH>
         <TD><html:reset /></TD>
        </TR>
        <TR>
         <TH>キャンセルボタン、リクエストがサーバに行く。処理を記述しないとSubmitと同じ操作</TH>
         <!-- 7）様々なボタンを表示する キャンセルボタン -->
         <TD><html:cancel /></TD>
        </TR>
       </TBODY>
      </TABLE>
     </TD>
　   </TBODY>
   </TABLE>
  </html:form>
 </BODY>
</html:html>