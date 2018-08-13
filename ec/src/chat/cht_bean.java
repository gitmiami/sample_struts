package chat;

import beanYama.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public class cht_bean implements Serializable {
	private ArrayList result;
	private class RoomBody {
		public String id;
		public String nam;
		public String comment;
		public java.util.Date dat;
		public java.util.Date dat2;
		public String icon;
	}
	public ResultSet getRoomInfo() {
		ResultSet rs=null;
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			rs=objSql.executeQuery("SELECT * FROM cht_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void getBodyInfo(String id) {
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			ResultSet rs=objSql.executeQuery("SELECT * FROM cht_master WHERE id=" + id + " ORDER BY dat DESC");
			result=new ArrayList();
			while(rs.next()){
				RoomBody objRoom=new RoomBody();
				objRoom.id     =rs.getString("id");
				objRoom.nam    =rs.getString("nam");
				objRoom.comment=rs.getString("comment");
				objRoom.dat    =rs.getDate("dat");
				objRoom.dat2   =rs.getTime("dat");
				objRoom.icon   =rs.getString("icon");
				result.add(objRoom);
			}
			objSql.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getResultCount(){
		return result.size();
	}
	public String getId(int index){
		RoomBody objRoom=(RoomBody)result.get(index);
		return objRoom.id;
	}
	public String getNam(int index){
		RoomBody objRoom=(RoomBody)result.get(index);
		return objRoom.nam;
	}
	public String getComment(int index){
		RoomBody objRoom=(RoomBody)result.get(index);
		return objRoom.comment;
	}
	public String getDat(int index){
		RoomBody objRoom=(RoomBody)result.get(index);
		return EncodeUtil.formatDate("yyyy”NMMŒŽdd“ú",objRoom.dat) + EncodeUtil.formatDate(" HH:mm:ss",objRoom.dat2);
	}
	public String getIcon(int index){
		RoomBody objRoom=(RoomBody)result.get(index);
		return objRoom.icon;
	}
}
