package com.lz.student.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.lz.commn.uitl.DBUtil;

public class StudentRegDao {

	public boolean studentReg(String name,String email,String studentno,String departrue,String grade){
		Connection con=DBUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		try {
			qr.update(con, "insert into reg (name,email,studentno,departrue,grade) values (?,?,?,?,?)", name, email,
					studentno,departrue,grade);
			return true;
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
	

}
