package com.lz.leader.dao;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.User;


public class ModifyPasswordDao {
	
	public User checkPassword(int lid){
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			User  user=  (User) qr.query(con, "select password from userlogin where lid=?",new BeanHandler<>(User.class),lid);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);	
		}
		return null;
	}
	public boolean changePassword(String password,int lid){
		
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			  qr.update(con,"update userlogin set password=? where lid=?",password,lid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);	
		}
		return false;
		
		
	}

}
