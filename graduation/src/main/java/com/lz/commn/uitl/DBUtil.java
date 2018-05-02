package com.lz.commn.uitl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 数据库连�?
 * @author rocket
 *
 */
public class DBUtil {
	
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		Properties props = new Properties();
		InputStream in = DBUtil.class.getResourceAsStream("/config.properties");
		try {
			props.load(in);
			driverClass = props.getProperty("driverClass");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 链接数据连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 断开数据库连�?
	 * @param rs
	 * @param st
	 * @param con
	 */
	public static void closeConnection(ResultSet rs,Statement st,Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st!=null) {
				st.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
