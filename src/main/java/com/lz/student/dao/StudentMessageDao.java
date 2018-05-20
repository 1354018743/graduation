package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Leader;
import com.lz.common.entity.Student;

public class StudentMessageDao {

	//更加登录号加载学生信息
	public Student loadStudentMessageByLid(int lid) {
		Connection connection =DBUtil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		try {
			Student student=(Student)queryRunner.query(connection, "select * from student where Lid=?", new BeanHandler(Student.class),lid);
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return null;
	}
	
	//修改审核人员信息
	public boolean modifyStudentMessage(int sid,String name,String departure,String grade,String email ) {
		Connection connection= DBUtil.getConnection();
		QueryRunner queryRunner= new QueryRunner();
		try {
			queryRunner.update(connection, "update student set name=?,departure=?,grade=?,email=? where sid=?",name,departure,grade,email,sid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(null, null, connection);
		}
		return false;
	}
}
