package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.ApplyProgress;
import com.lz.common.entity.Leader;
import com.lz.common.entity.Reg;

/**
 * 从数据库获取信息相关类
 * @author ASUS
 *
 */
public class ManagerRegDao {
	
	
	public List<Reg> queryAllCompany() {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Reg> regs=queryRunner.query(connection, "select * from reg where state=1", new BeanListHandler<>(Reg.class));

			return regs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//分页查询申请信息
	 public  List<Reg>  queryPage(int page,int pageSize){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			List<Reg> list=  qr.query(con, "select * from reg where state=1 limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(Reg.class));
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	 }

	  //增加学生
	    public boolean accessReg(int regid,String studentno,String password,String name, String email,String departure,String grade){
	    	Connection connection=DBUtil.getConnection();
			PreparedStatement ps=null;
			ResultSet rSet=null;
			QueryRunner queryRunner =new QueryRunner();
			try {
				connection.setAutoCommit(false);
				ps=connection.prepareStatement("insert into userlogin(username,password,statem,usertype) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1,studentno);
				ps.setString(2, password);
				ps.setInt(3,1);
				ps.setInt(4,1 );
				ps.executeUpdate();
				rSet=ps.getGeneratedKeys();
				if(rSet.next()) {
					int Lid=rSet.getInt(1);
					queryRunner.update(connection,"insert into student(stuno, name,email,departure,grade,lid,state) values(?,?,?,?,?,?,?)",studentno,name,email,departure,grade,Lid,1);
					queryRunner.update(connection,"update reg set state=0 where regid=?",regid);
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
		
		public boolean modifyReg(int regid){
			
			Connection con=DBUtil.getConnection();
			QueryRunner qr=new QueryRunner();
			try {
				  qr.update(con,"update reg set state=0 where regid=?",regid);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(null, null, con);	
			}
			return false;
			
			
		}
}
