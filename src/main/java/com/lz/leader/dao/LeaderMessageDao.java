package com.lz.leader.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Leader;

public class LeaderMessageDao {

	//更加登录号加载审核人员信息
	public Leader loadLeaderMessageByLid(int lid) {
		Connection connection =DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			Leader leader=(Leader)queryRunner.query(connection, "select * from leader where Lid=?", new BeanHandler(Leader.class),lid);
			return leader;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//修改审核人员信息
	public boolean modifyLeaderMessage(int leaderid,String name,String leaderno,String job,String departure,String workplace,String phone ) {
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner= new QueryRunner();
		try {
			queryRunner.update(connection, "update leader set name=?,leaderno=?,job=?,departure=?,workplace=?,phone=? where leaderid=?",name,leaderno,job,departure,workplace,phone,leaderid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return false;
	}
}
