package com.lz.leader.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.taglibs.standard.lang.jstl.NotEqualsOperator;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.AirCompany;

public class AirlinCompanyMessageDao {

	//更加登录号加载航空公司信息
	public AirCompany loadCompanyMessageByLid(int lid) {
		Connection connection =DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			AirCompany airCompany=(AirCompany)queryRunner.query(connection, "select * from company where Lid=?", new BeanHandler(AirCompany.class),lid);
			return airCompany;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//修改航空公司信息
	public boolean modifyCompanyMessage(String inst_number,String com_name,String com_telnumber) {
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner= new QueryRunner();
		try {
			queryRunner.update(connection, "update company set com_name=?,com_telnumber=? where inst_number=?",com_name,com_telnumber,inst_number);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return false;
	}
}
