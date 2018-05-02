package com.lz.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Passenger;

public class Passergerlogindao {
  public Passenger loginbyusername(String username){
	
	 Connection con=DBUtil.getConnection();
	 ResultSet re=null;
	 PreparedStatement pre=null;
	 Passenger pass=null;
	 try {
	    pre=con.prepareStatement("SELECT * FROM  passenger WHERE username=? or cardid=? or email=?");
		pre.setString(1, username);
		pre.setString(2, username);
		pre.setString(3, username);
	    System.out.println(pre);
	    re=pre.executeQuery();
	    if(re.next()) {
		    pass=new Passenger(re.getString("username"), re.getString("password"), re.getString("realname"), re.getString("cardid"), re.getInt("sex"),re.getString("tel_number"), re.getString("email"), re.getString("picture"));
	    }
		return pass;
	 } catch (SQLException e) {
		e.printStackTrace();
	 }finally {
		 DBUtil.closeConnection(re, pre, con);
	 }  
  return null;	  
  }
}
