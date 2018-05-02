package com.lz.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Passenger;

public class Passergereigitdao {
	//�ж��û��Ƿ����
			public Boolean isexitusename(String username) {
				ResultSet rs = null;
				Passenger passenger = null;
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement("select * from passenger where username = ? ");
					ps.setString(1, username);
					rs = ps.executeQuery();
					if(rs.next()) {
						passenger =new Passenger();
					}
					if(passenger!=null) {
						return true;
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}finally {
					DBUtil.closeConnection(rs, ps, con);;
				}	
				
			 return false;
			} 
		//ע���������ݿ�
			public Boolean gotodatabase(Passenger passenger) {
				Connection con = DBUtil.getConnection();
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					 ps = con.prepareStatement("insert into passenger(username,password,realname, cardid,sex,tel_number,email,picture) values(?,?,?,?,?,?,?,?)");
					ps.setString(1, passenger.getUsername());
					ps.setString(2, passenger.getPassword());
					ps.setString(3, passenger.getRealname());
					ps.setString(4, passenger.getCardid());
					ps.setInt(5, passenger.getSex());
					ps.setString(6, passenger.getTel_number());
					ps.setString(7, passenger.getEmail());
					ps.setString(8, passenger.getfileUIL());
					ps.executeUpdate();
				    return true;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					DBUtil.closeConnection(rs, ps, con);
				}	
				return false;
			}
}
