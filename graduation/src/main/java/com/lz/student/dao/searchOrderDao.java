package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Order;
import com.lz.common.entity.Passenger;
 
/*
 * 查询所有订单信息
 */
public class searchOrderDao {
	
	
	public List<Order> searchOrder(){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Order> list = qr.query(con,"select insurance,pre_state,setouttime,achieve,com_name,realname from ordertable o join flight f on o.fid=f.fid join company c on f.cid=c.cid join passenger p on o.pid=p.pid", new BeanListHandler<>(Order.class));
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null,null,con);
		}
		return null;
	}
	/*
	 * 分页查询所有订单信息
	 */
	public List<Order> searchOrderPage(int pageNum, int pageSize){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Order> list = qr.query(con,"select insurance,pre_state,setouttime,achieve,com_name,realname from ordertable o join flight f on o.fid=f.fid join company c on f.cid=c.cid join passenger p on o.pid=p.pid limit "+(pageNum-1)*pageSize+","+pageSize,new BeanListHandler<>(Order.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null,null, con);
		}
		return null;
	}
}
