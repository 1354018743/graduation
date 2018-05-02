package com.lz.leader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Descount;
import com.lz.common.entity.FlightMessage;

public class AirlineDescountDao {
	//加载所有的折扣机票信息
	public List<Descount> loadAllDescount(int cid){
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		List<Descount> descount;
		try {
			descount = qr.query(con, "select f.fid,f.cid,d.did,"+
			"(select port_name from airport c where f.star_airportnumber=aid) as port_name,"+
			"(select port_name from airport d where f.end_airportnumber=aid) as end_port_name,"+
			"f.setouttime,f.achieve,price_1,descount_1,genre_1,price_2,descount_2,genre_2 "+
			"from flight f join airticket a on f.fid=a.fid join descount d on a.fid=d.fid "+
			"where cid=? and  state=1",new BeanListHandler<>(Descount.class),cid);
			return descount;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
	//分页加载折扣机票信息
	public List<Descount> loadDescountByPage(int page,int rows,int cid){
		Connection con1=DBUtil.getConnection();
		QueryRunner qr1=new QueryRunner();
		List<Descount> descount;
		try {
			descount = qr1.query(con1, "select f.fid,f.cid,d.did,"+
					"(select port_name from airport c where f.star_airportnumber=aid) as port_name,"+
					"(select port_name from airport d where f.end_airportnumber=aid) as end_port_name,"+
					"f.setouttime,f.achieve,price_1,descount_1,genre_1,price_2,descount_2,genre_2 "+
					"from flight f join airticket a on f.fid=a.fid join descount d on a.fid=d.fid "+
					"where cid=? and state=1 limit "+((page-1)*rows)+","+rows,new BeanListHandler<>(Descount.class),cid);
			return descount;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con1);
		}
		return null;
	
	}
	
	//增加优惠政策
	public boolean addDescount(int fid,double descount_1,double descount_2){
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.update(con, "insert into descount(descount_1,descount_2,fid) values(?,?,?)",descount_1,descount_2,fid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}
	
	//修改优惠政策
	public boolean modifyDescount(int fid, double descount_1,double descount_2){
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.update(con, "update descount set descount_1=?,descount_2=? where fid=?",descount_1,descount_2,fid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, con);
		}
		return false;
	}
	
	//查找所有符合条件的折扣信息
	public List<Descount> searchAllDescount(String sql){
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Descount> descounts=queryRunner.query(connection,sql, new BeanListHandler<>(Descount.class));
			return descounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
		
	}
		
	//分页查找符合条件的折扣信息
	public List<Descount> searchDescount(String sql){
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Descount> descounts=queryRunner.query(connection, sql, new BeanListHandler<>(Descount.class));
			return descounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}

}
