package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.ApplyProgress;

/**
 * 从数据库获取信息相关类
 * @author ASUS
 *
 */
public class MStudentApplyMessageDao {
	

	public List<ApplyProgress> queryApplyMessage(String sno,String sname) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			System.out.println(sname);
			List<ApplyProgress> applyProgress=queryRunner.query(connection, "select * from applyprogress where sno like '%"+sno+"%' and sname like '%"+sname+"%'", new BeanListHandler<>(ApplyProgress.class));

			return applyProgress;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//分页查询申请信息
	 public  List<ApplyProgress>  queryPage(int page,int pageSize,String sno,String sname){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			List<ApplyProgress> list=  qr.query(con, "select * from applyprogress where sno like '%"+sno+"%' and sname like '%"+sname+"%' limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(ApplyProgress.class));
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	 }

}
