package com.lz.leader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.FlightMessage;

/**
 * 航班信息数据库处理类
 * @author ASUS
 *
 */
public class FlightMessageDao {
	
	//加载所有航班信息
	public List<FlightMessage> loadAllFlightMessage(int cid) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<FlightMessage> flightMessages=queryRunner.query(connection, "select  a.fid,a.air_number,a.setouttime,a.achieve,a.cid,"
			+"(select port_name from airport c where a.star_airportnumber=c.aid) as port_name,"
			+"(select port_name from airport d where a.end_airportnumber=d.aid) as end_port_name,"
			+"a.state,b.price_1,b.pricecount_1,b.genre_1,b.price_2,b.pricecount_2,b.genre_2  "
			+"from flight a join airticket b on a.fid=b.fid "
			+"where cid=? and state=1", new BeanListHandler<>(FlightMessage.class),cid);
			return flightMessages;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
		
	}
		
	//分页加载航班信息
	public List<FlightMessage> loadFlightMessageByPag(int pag,int rows,int cid) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			
			List<FlightMessage> flightMessages=queryRunner.query(connection, "select  a.fid,a.air_number,a.setouttime,a.achieve,a.cid,"
			+"(select port_name from airport c where a.star_airportnumber=c.aid) as port_name,"
			+"(select port_name from airport d where a.end_airportnumber=d.aid) as end_port_name,"
			+"a.state,b.price_1,b.pricecount_1,b.genre_1,b.price_2,b.pricecount_2,b.genre_2  "
			+"from flight a join airticket b on a.fid=b.fid  "
			+"where cid=? and state=1 limit "+(pag-1)*rows+","+rows, new BeanListHandler<>(FlightMessage.class),cid);
			return flightMessages;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//增加航班信息
	public boolean addFlight(String air_number,Date setouttime,Date achieve,int cid,int star_airportnumber,int end_airportnumber,double price_1,int pricecount_1,String genre_1,double price_2,int pricecount_2,String genre_2) {
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rSet=null;
		QueryRunner queryRunner =new QueryRunner();
		java.sql.Timestamp sqlsetouttime=new java.sql.Timestamp(setouttime.getTime());
		java.sql.Timestamp sqlachieve=new java.sql.Timestamp(achieve.getTime());
		try {
			connection.setAutoCommit(false);
			ps=connection.prepareStatement("insert into flight(air_number,setouttime,achieve,cid,star_airportnumber,end_airportnumber) values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, air_number);
			ps.setTimestamp(2, sqlsetouttime);
			ps.setTimestamp(3,sqlachieve);
			ps.setInt(4, cid);
			ps.setInt(5,star_airportnumber );
			ps.setInt(6, end_airportnumber);
			ps.executeUpdate();
			rSet=ps.getGeneratedKeys();
			if(rSet.next()) {
				int fid=rSet.getInt(1);
				queryRunner.update(connection,"insert into airticket(price_1,pricecount_1,genre_1,price_2,pricecount_2,genre_2,fid) values(?,?,?,?,?,?,?)",price_1,pricecount_1,genre_1,price_2,pricecount_2,genre_2,fid);
				connection.commit();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(rSet, ps, connection);
		}
		return false;
	}
	//删除航班
	public boolean deleteFlightMessage(int[] fids) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			connection.setAutoCommit(false);
			for(int fid:fids){
				queryRunner.update(connection, "update flight set state=2 where fid=?",fid);
			}
			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return false;
	}
	//修改航班
	public boolean modifyFlightMessage(int fid,String air_number,Date setouttime,Date achieve,double price_1,int pricecount_1,double price_2,int pricecount_2) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		java.sql.Timestamp sqlsetouttime=new java.sql.Timestamp(setouttime.getTime());
		java.sql.Timestamp sqlachieve=new java.sql.Timestamp(achieve.getTime());
		try {
			connection.setAutoCommit(false);
			queryRunner.update(connection, "update flight set air_number=?,setouttime=?,achieve=?  where fid=?",air_number,sqlsetouttime,sqlachieve,fid);
			queryRunner.update(connection, "update airticket set price_1=?,pricecount_1=?,price_2=?,pricecount_2=?  where fid=?",price_1,pricecount_1,price_2,pricecount_2,fid);
			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return false;
	}
	//查找所有符合条件的航班信息
	public List<FlightMessage> searchAllFlightMessage(String sql){
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<FlightMessage> flightMessages=queryRunner.query(connection,sql, new BeanListHandler<>(FlightMessage.class));
			return flightMessages;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
		
	}
		
	//分页查找符合条件的航班信息
	public List<FlightMessage> searchFlightMessage(String sql){
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<FlightMessage> flightMessages=queryRunner.query(connection, sql, new BeanListHandler<>(FlightMessage.class));
			return flightMessages;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
}
