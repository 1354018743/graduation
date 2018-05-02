package com.lz.leader.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Airport;

/**
 * 从数据库获取机场信息相关类
 * @author ASUS
 *
 */
public class AirportMessageDao {

	public List<Airport> loadAirport() {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Airport> airports=queryRunner.query(connection, "select * from airport where state=1", new BeanListHandler<>(Airport.class));
			return airports;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
}
