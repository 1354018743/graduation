package com.lz.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.lz.commn.uitl.DBUtil;

public class ApplyUploadDao {
	
	public boolean addApply(String studentno,String name,int lid,int population,String country,String allowances,String ranking,String principle,String subsidize,String spending, String work) throws ParseException{
		
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rSet=null;
		QueryRunner queryRunner =new QueryRunner();
		try {
			connection.setAutoCommit(false);
			ps=connection.prepareStatement("insert into apply(studentno,name,lid,population, country, allowances, ranking, principle, subsidize, spending, work) values(?,?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1,studentno);
			ps.setString(2,name);
			ps.setInt(3,lid);
			ps.setInt(4,population);
			ps.setString(5, country);
			ps.setString(6,allowances);
			ps.setString(7,ranking );
			ps.setString(8,principle );
			ps.setString(9,subsidize );
			ps.setString(10,spending );
			ps.setString(11,work);
			ps.executeUpdate();
			rSet=ps.getGeneratedKeys();
			if(rSet.next()) {
				int aid=rSet.getInt(1);
				Date date = new Date();//获得系统时间.
		        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		        String nowTime = sdf.format(date);
		        Date time = sdf.parse( nowTime );
				int score=getScore(population, country, allowances, ranking, principle, subsidize, spending, work);
				queryRunner.update(connection,"insert into applyprogress(sname, sno, score,applytime,progress,aid,lid) values(?,?,?,?,?,?,?)",name,studentno,score,time,0,aid,lid);
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
	
	public int getScore(int population,String country,String allowances,String ranking,String principle,String subsidize,String spending, String work){
		int pop=0;
		int con=0;
		int all=0;
		int ran=0;
		int pri=0;
		int sub=0;
		int spe=0;
		int wor=0;
		if(pop==2){
			pop=3;
		}else if(pop==3){
			pop=6;
		}else if(pop==4){
			pop=9;
			
		}else{
			pop=12;
			
		}
		if(country.equals("农村")){
			con=12;
		}else{
			pop=6;
			
		}
		if(allowances.equals("低保家庭")){
			all=12;
		}else{
			all=6;
			
		}
		if(ranking.equals("前五")){
			ran=12;
		}else if(ranking.equals("前十")){
			ran=9;
		}else{
			ran=6;	
		}
		if(principle.equals("没有")){
			pri=12;
		}else{
			pri=6;
			
		}
		if(subsidize.equals("没有")){
			sub=12;
		}else{
			sub=6;
			
		}
		if(spending.equals("1000以内")){
			spe=12;
		}else if(spending.equals("1000-2000")){
			spe=9;
		}else{
			spe=6;	
		}
		if(work.equals("管理层")){
			wor=3;
		}else if(work.equals(" 工人阶层")){
			wor=6;
		}else if(work.equals("农民")){
			wor=9;
			
		}else{
			wor=12;
			
		}
		return pop+con+all+ran+pri+sub+spe+wor;
	}

}
