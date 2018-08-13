package ec;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ec_bean implements Serializable {
	public ResultSet getStore(){
		ResultSet rs=null;
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			rs=objSql.executeQuery("SELECT * FROM ec_store ORDER BY id ASC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet getProduct(String store){
		ResultSet rs=null;
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			rs=objSql.executeQuery("SELECT * FROM ec_product WHERE stor=" + store);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet getProduct(){
		ResultSet rs=null;
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			rs=objSql.executeQuery("SELECT * FROM ec_product ORDER BY code ASC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int setCustomer(String nam,String zip,String address,String tel){
		int intRst=0;
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			ResultSet rs=objSql.executeQuery("SELECT max(id)+1 AS new_id FROM ec_customer");
			if(rs.next()){
				intRst=rs.getInt("new_id");
			}else{
				intRst=1;
			}
			objSql.executeUpdate("INSERT INTO ec_customer(id,nam,zip,address,tel) VALUES(" + intRst + ",'" + nam + "','" + zip + "','" + address + "','" + tel + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return intRst;
	}
	public void setOrder(String code,String num,int id){
		ResourceBundle objRB=ResourceBundle.getBundle("dbConnect");
		try {
			Class.forName(objRB.getString("jdbcDriver"));
			Connection db=DriverManager.getConnection(objRB.getString("conStr"));
			Statement objSql=db.createStatement();
			objSql.executeUpdate("INSERT INTO ec_master(code,num,person) VALUES('" + code + "','" + num + "','" + id + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
