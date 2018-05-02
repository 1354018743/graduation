package com.lz.leader.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.User;

public class LoginDao {
	PreparedStatement ps=null;
	ResultSet rs=null;
	User user=null;
	//根据用户名获取用户信息
	public User getUserByName(String username) {
		Connection connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("select * from userlogin where username=?");
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User(rs.getInt("Lid"), rs.getString("username"), rs.getString("password"), rs.getString("statem"), rs.getInt("usertype"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(rs, ps, connection);
		}
		return null;
	}
	
}
