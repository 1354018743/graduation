package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Order;
import com.lz.common.entity.Passenger;

public class UserMessageDao {
	
	public List<Passenger> loadUserMessage(String username,String password){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Passenger> list = qr.query(con, "select username,password,realname,cardid,sex,tel_number,email,picture from passenger where username=? and password=?", new BeanListHandler<>(Passenger.class),username,password);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return null;
		
	}
	
	public boolean queryUserMessage(Passenger passenger){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.query(con, "update passenger set username=?,password=?,realname=?,cardid=?,sex=?,tel_number=?,email=?,picture=? where pid=?", new BeanListHandler<>(Passenger.class),passenger.getUsername(),passenger.getPassword(),passenger.getRealname(),passenger.getCardid(),passenger.getSex(),passenger.getTel_number(),passenger.getEmail(),passenger.getfileUIL(),passenger.getPid());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}

}
