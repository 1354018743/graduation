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
import com.lz.common.entity.Student;
import com.lz.common.entity.Student;

/**
 * 从数据库获取信息相关类
 * @author ASUS
 *
 */
public class ManagerStudentDao {

	public List<Student> queryAllStudent(String studentno,String name) {
		Connection connection=DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			List<Student> students=queryRunner.query(connection, "select * from student where stuno like '%"+studentno+"%' and name like '%"+name+"%' and state=1 ", new BeanListHandler<>(Student.class));

			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//分页查询申请信息
	 public  List<Student>  queryPage(int page,int pageSize,String studentno,String name){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			List<Student> list=  qr.query(con, "select * from student where stuno like '%"+studentno+"%' and name like '%"+name+"%' and state=1 limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(Student.class));
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	 }
	 
	 public  boolean modifyStudentPower(int rank,int Studentid){
		 
		 Connection con=DBUtil.getConnection();
		  QueryRunner qr=new QueryRunner();
		try {
			qr.update(con,"update Student set rank=? where Studentid=?",rank,Studentid);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	 }

	// 删除数据
	   public boolean deleteStudent(int[] sids){
		   Connection con=DBUtil.getConnection();
		   	QueryRunner qr=new QueryRunner();
		   try {
		       con.setAutoCommit(false);
		       for(int sid:sids){
		    	   qr.update(con," update  student join userlogin on student.lid=userlogin.Lid set state=0,statem=0 where sid=?",sid);
		    	   
		    	   
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
	    public boolean addStudent(String stuno,String password,String name,String departure,String grade,String email){
	    	Connection connection=DBUtil.getConnection();
			PreparedStatement ps=null;
			ResultSet rSet=null;
			QueryRunner queryRunner =new QueryRunner();
			try {
				connection.setAutoCommit(false);
				ps=connection.prepareStatement("insert into userlogin(username,password,statem,usertype) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1,stuno);
				ps.setString(2, password);
				ps.setInt(3,1);
				ps.setInt(4,1 );
				ps.executeUpdate();
				rSet=ps.getGeneratedKeys();
				if(rSet.next()) {
					int Lid=rSet.getInt(1);
					queryRunner.update(connection,"insert into student(stuno, name,departure,grade,email,lid,state) values(?,?,?,?,?,?,?)",stuno,name,departure,grade,email,Lid,1);
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
