package chat;

import beanYama.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class cht_update extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		HttpSession session=request.getSession();
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			PreparedStatement objPst=db.prepareStatement("INSERT INTO cht_master(id,nam,comment,dat,icon) VALUES(?,?,?,?,?)");
			objPst.setString(1,(String)session.getAttribute("frmNam"));
			objPst.setString(2,(String)session.getAttribute("nam"));
			objPst.setString(3,request.getParameter("comment"));
			objPst.setString(4,EncodeUtil.formatDate("yyyy-MM-dd HH:mm:ss"));
			objPst.setString(5,(String)session.getAttribute("face"));
			objPst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/advanced/servlet/chat.cht_forum");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		doGet(request,response);
	}
}