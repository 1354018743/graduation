package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Airport;


public class AirportDao {
	/**
	 * 
	 * ��ҳ��ѯ
	 * @param pageNum
	 * @param pageSize
	 * @param port_number
	 * @param port_name
	 * @param city
	 * @return
	 */
public List<Airport> loadAirport(int pageNum,int pageSize,String port_number,String port_name,String city){
		
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		
		try {
			List<Airport>  list = qr.query(con,"select * from airport where port_number like '%"+port_number+"%' and port_name like '%"+port_name+"%' and city like '%"+city+"%'  limit "+(pageNum-1)*pageSize+","+pageSize, new BeanListHandler<>(Airport.class));
			
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
/**
 * 
 * ��ѯ����
 * @param port_number
 * @param port_name
 * @param city
 * @return
 */
public List<Airport> allAirport(String port_number,String port_name,String city){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		List<Airport>  list = qr.query(con,"select * from airport where port_number like '%"+port_number+"%' and port_name like '%"+port_name+"%' and city like '%"+city+"%' ", new BeanListHandler<>(Airport.class));
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
/**
 * 
 * 
 * 
 * 
 * ��ѯ����
 * @return
 * 
 * 
 * 
 */
public List<Airport> searchAirport(String port_number,String port_name,String city){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	String sql="select * from airport where";
	if(port_number!=null&&port_name!=null&&city!=null){
		
		sql+=" port_number like '%"+port_number+"%' and  port_name like '%"+port_name+"%' and city like '%"+city+"%'";
		System.out.println(sql);
	}

	
	try {
		List<Airport>  list = qr.query(con,sql, new BeanListHandler<>(Airport.class));
		System.out.println(list);
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
/**
 * 
 * 
 * ����aid��ѯ������Ϣ
 * @return
 */
public Airport loadAirportByAid(int aid){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		Airport airport = qr.query(con,"select * from airport where aid=?", new BeanHandler<>(Airport.class),aid);
		return airport;
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
/**
 * 
 * �޸Ļ�����Ϣ
 * @param aid
 * @param port_number
 * @param port_name
 * @param city
 * @return
 */
public boolean modifyAirport(int aid ,String port_number,String port_name,String city){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		qr.update(con,"update airport set port_number=?,port_name=?,city=? where aid=?",port_number,port_name,city,aid);
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

/**
 * 
 * ��ӻ���
 * @param port_number
 * @param port_name
 * @param city
 * @return
 */
public boolean addAirport(String port_number,String port_name,String city){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		qr.update(con,"insert into airport (port_number,port_name,city) values (?,?,?)",port_number,port_name,city );
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

/*
 * 
 * ɾ������
 */
public boolean deleteAirport(int[] aids){
	
	Connection con=DBUtil.getConnection();
	QueryRunner qr=new QueryRunner();
	
	try {
		con.setAutoCommit(false);
		for(int aid:aids){
		qr.update(con,"delete from airport where aid=?",aid);
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
