package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Apply;
import com.lz.common.entity.ApplyProgress;

/**
 * 从数据库获取申请信息相关类
 * @author ASUS
 *
 */
public class ExportDao {
	

	public List<Apply> queryApply(int aid) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Apply> applys=queryRunner.query(connection, "select * from apply where aid=?", new BeanListHandler<>(Apply.class),aid);
			return applys;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}

}
