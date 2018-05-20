package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.ApplyProgress;
import com.lz.common.entity.Leader;

/**
 * 从数据库获取信息相关类
 * @author ASUS
 *
 */
public class StudentApplyMessageDao {
	
	
	public int getRank(int lid){
		
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Leader> leaders=queryRunner.query(connection, "select * from leader where lid=?", new BeanListHandler<>(Leader.class),lid);
			int rank =leaders.get(0).getRank();
			System.out.println(rank);
			return rank;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return 0;
		
	}
	

	public List<ApplyProgress> queryAllCompany(int lid,String sno,String sname) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		int rank=getRank(lid)-1;
		try {
			System.out.println(sname);
			List<ApplyProgress> applyProgress=queryRunner.query(connection, "select * from applyprogress where  progress="+rank+"", new BeanListHandler<>(ApplyProgress.class));

			return applyProgress;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//分页查询申请信息
	 public  List<ApplyProgress>  queryPage(int page,int pageSize,int lid,String sno,String sname){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		  int rank=getRank(lid)-1;
		try {
			List<ApplyProgress> list=  qr.query(con, "select * from applyprogress where  progress="+rank+" limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(ApplyProgress.class));
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	 }

}
