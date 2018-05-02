package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Airport;
import com.lz.common.entity.User1;

public class PassengerDao {
	
public List<User1> loadPassenger(int pageNum,int pageSize,String realname,String cardid,String tel_number,String email){
		
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		
		try {
			List<User1>  list = qr.query(con,"select * from passenger where state=1 and realname like '%"+realname+"%' and cardid like '%"+cardid+"%'and tel_number like '%"+tel_number+"%'and email like '%"+email+"%'  limit "+(pageNum-1)*pageSize+","+pageSize, new BeanListHandler<>(User1.class));
			return list;
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

public List<User1> allPassenger(String realname,String cardid,String tel_number,String email){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		List<User1>  list = qr.query(con,"select * from passenger where state=1 and realname like '%"+realname+"%' and cardid like '%"+cardid+"%'and tel_number like '%"+tel_number+"%'and email like '%"+email+"%'", new BeanListHandler<>(User1.class));
		return list;
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

public boolean deletePassenger(int[] pids){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		con.setAutoCommit(false);
		for(int pid:pids){
		qr.update(con,"update passenger set state=0 where pid=?",pid);
		}
		con.commit();
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
