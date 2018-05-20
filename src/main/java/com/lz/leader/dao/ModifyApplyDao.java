package com.lz.leader.dao;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.User;


public class ModifyApplyDao {
	
	
	public boolean accessApply(int aiid){
		
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			  qr.update(con,"update applyprogress set progress=progress+1 where aiid=?",aiid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);	
		}
		return false;
		
		
	}
	
	public boolean modifyApply(int aiid){
		
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			  qr.update(con,"update applyprogress set progress=-1 where aiid=?",aiid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);	
		}
		return false;
		
		
	}

}
