package chat;

import chat.*;
import beanYama.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class cht_forum extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		HttpSession session=request.getSession();
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			if(request.getAttribute("frmNam")!=null){
				session.setAttribute("frmNam",request.getParameter("frmNam"));
				session.setAttribute("nam",request.getParameter("nam"));
				session.setAttribute("face",request.getParameter("face"));
				session.setAttribute("rTime",request.getParameter("rTime"));
				Class.forName(objRB.getString("jdbcDriver"));
				Connection db=DriverManager.getConnection(objRB.getString("conStr"));
				Statement objSql=db.createStatement();
				ResultSet rs=objSql.executeQuery("SELECT * FROM cht_list WHERE id=" + request.getParameter("frmNam"));
				if(rs.next()){
					session.setAttribute("namc",rs.getString("namc"));
					session.setAttribute("timc",rs.getString("timc"));
					session.setAttribute("comc",rs.getString("comc"));
				}
			}
			String strNam=(String)session.getAttribute("frmNam");
			cht_bean objCht=new cht_bean();
			objCht.getBodyInfo(strNam);
			request.setAttribute("objCht",objCht);
			getServletConfig().getServletContext().getRequestDispatcher("/chap2/chat/forum.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		doGet(request,response);
	}
}