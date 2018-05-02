package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.AirCompany;
import com.lz.common.entity.User;

public class ManagerChangPasswordDao {
	public User getUserbylid(int Lid){
		   Connection con=DBUtil.getConnection();
		    QueryRunner qr=new QueryRunner();
		    User user=null;
		     try {
				user=qr.query(con, "select * from userlogin where Lid=?",new BeanHandler<>(User.class),Lid);
				  return user;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					DbUtils.close(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		   return null;
		    
	}
	public boolean updatePassword(int Lid,String password){
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.update(con,"update userlogin set password=? where Lid=?",password,Lid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
