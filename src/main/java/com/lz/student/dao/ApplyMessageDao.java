package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.ApplyProgress;

/**
 * 从数据库获取机场信息相关类
 * @author ASUS
 *
 */
public class ApplyMessageDao {
	

	public List<ApplyProgress> queryAllCompany(int lid) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<ApplyProgress> applyProgress=queryRunner.query(connection, "select * from applyprogress where lid=?", new BeanListHandler<>(ApplyProgress.class),lid);
			System.out.println(applyProgress.get(0).getScore());
			return applyProgress;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//分页查询航空公司信息
	 public  List<ApplyProgress>  queryPage(int page,int pageSize,int lid){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			List<ApplyProgress> list=  qr.query(con, "select * from applyprogress where lid=? limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(ApplyProgress.class),lid);
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	 }

}
