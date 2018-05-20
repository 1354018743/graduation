package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Leader;

/**
 * 从数据库获取信息相关类
 * @author ASUS
 *
 */
public class ManagerLeaderDao {

	public List<Leader> queryAllLeader(String leaderno,String name) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Leader> leaders=queryRunner.query(connection, "select * from leader where leaderno like '%"+leaderno+"%' and name like '%"+name+"%' and state=1 ", new BeanListHandler<>(Leader.class));

			return leaders;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//分页查询申请信息
	 public  List<Leader>  queryPage(int page,int pageSize,String leaderno,String name){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			List<Leader> list=  qr.query(con, "select * from leader  where leaderno like '%"+leaderno+"%' and name like '%"+name+"%' and state=1 limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(Leader.class));
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	 }
	 
	 public  boolean modifyLeaderPower(int rank,int leaderid){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			qr.update(con,"update leader set rank=? where leaderid=?",rank,leaderid);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	 }

	// 删除数据
	   public boolean deleteLeader(int[] leaderids){
		   Connection con=DBUtil.getConnection();
		   	QueryRunner qr=new QueryRunner();
		   try {
		       con.setAutoCommit(false);
		       for(int leaderid:leaderids){
		    	   qr.update(con," update  leader join userlogin on leader.lid=userlogin.Lid set state=0,statem=0 where leaderid=?",leaderid);
		    	   
		    	   
		    	con.commit();
		    	   return true;	   
		       }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{	
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;    
	   }
	   
	   //增加审核人员
	    public boolean addLeader(String leaderno,String password,String name, String job,String departure,String workplace,String phone,int rank){
	    	Connection connection=DBUtil.getConnection();
			PreparedStatement ps=null;
			ResultSet rSet=null;
			QueryRunner queryRunner =new QueryRunner();
			try {
				connection.setAutoCommit(false);
				ps=connection.prepareStatement("insert into userlogin(username,password,statem,usertype) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1,leaderno);
				ps.setString(2, password);
				ps.setInt(3,1);
				ps.setInt(4,2 );
				ps.executeUpdate();
				rSet=ps.getGeneratedKeys();
				if(rSet.next()) {
					int Lid=rSet.getInt(1);
					queryRunner.update(connection,"insert into leader(leaderno, name, job,departure,workplace,phone,rank,lid,state) values(?,?,?,?,?,?,?,?,?)",leaderno,name, job,departure,workplace,phone,rank,Lid,1);
					connection.commit();
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeConnection(rSet, ps, connection);
			}
			return false;
	    	
	    }
	   
}
