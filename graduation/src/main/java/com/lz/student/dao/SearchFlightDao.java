package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Flight;
import com.lz.common.entity.Order;
 
public class SearchFlightDao {

	public List<Flight> searchFlight(){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Flight> list = qr.query(con, "select * from flight f join airport a on f.star_airportnumber=a.aid join airport a1 on f.end_airportnumber=a1.aid ",new BeanListHandler<>(Flight.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null,null,con);
		}
		return null;
	}
	public List<Flight> searchFlightPage(int pageNum, int pageSize){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Flight> list = qr.query(con,"select * from flight f join airport a on f.star_airportnumber=a.aid join airport a1 on f.end_airportnumber=a1.aid limit "+(pageNum-1)*pageSize+","+pageSize,new BeanListHandler<>(Flight.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null,null, con);
		}
		return null;
	}
}

