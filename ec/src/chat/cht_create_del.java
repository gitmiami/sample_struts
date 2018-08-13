package chat;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class cht_create_del extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		String flag="";
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql1=db.createStatement();
			Statement objSql2=db.createStatement();
			Statement objSql3=db.createStatement();
			if(request.getAttribute("ins") != null) {
				objSql1.executeUpdate("INSERT INTO cht_list(nam,passwd,namc,timc,comc) VALUES('" + request.getAttribute("nam") + "','" + request.getAttribute("passwd") + "','" + request.getAttribute("namI") + "','" + request.getAttribute("timI") + "','" + request.getAttribute("comI") + "')");
			}else{
				ResultSet rs=objSql1.executeQuery("SELECT * FROM cht_list WHERE id='" + request.getAttribute("nam") + "' AND passwd='" + request.getAttribute("passwd") + "'");
				if(rs.next()){
					objSql2.executeUpdate("DELETE FROM cht_list WHERE id=" + request.getAttribute("nam"));
					objSql3.executeUpdate("DELETE FROM cht_master WHERE id=" + request.getAttribute("nam"));
				}else{
					flag="true";
				}
			}
			objSql1.close();
			objSql2.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/advanced/chap2/chat/admin.jsp?flag=" + flag);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		doGet(request,response);
	}
}
