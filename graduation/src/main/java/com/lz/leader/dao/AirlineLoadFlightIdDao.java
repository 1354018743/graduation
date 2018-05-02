package com.lz.leader.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.FlightId;
/**
 * 加载航班编号
 * @author ASUS
 *
 */
public class AirlineLoadFlightIdDao {
	//根据公司编号加载航班编号
	public List<FlightId> loadFlightId(int cid) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		List<FlightId> flightIds;
		try {
			flightIds=queryRunner.query(connection, "select * from flight where cid=? and state=1 and fid not in(select fid from descount)",new BeanListHandler<>(FlightId.class), cid);
			return flightIds;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
}
