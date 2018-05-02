package com.lz.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.AirCompany;


//查询所以航空公司信息
public class ManagerAirCompanyDao {
	public List<AirCompany> queryAllCompany(String inst_number,String com_name,String com_telnumber){
	 Connection con=DBUtil.getConnection();
	  QueryRunner qr=new QueryRunner();
	try {
		List<AirCompany> list=  qr.query(con, "select * from company where inst_number like '%"+inst_number+"%' and com_name like '%"+com_name+"%' and com_telnumber like '%"+com_telnumber+"%' and state=1  ",new BeanListHandler<>(AirCompany.class) );
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
	}return null;
}

//分页查询航空公司信息
 public  List<AirCompany>  queryPage(int page,int pageSize,String inst_number,String com_name,String com_telnumber){
	 
	 Connection con=DBUtil.getConnection();
	  QueryRunner qr=new QueryRunner();
	try {
		List<AirCompany> list=  qr.query(con, "select * from company where inst_number like '%"+inst_number+"%' and com_name like '%"+com_name+"%' and com_telnumber like '%"+com_telnumber+"%' and state=1  limit "+(page-1)*pageSize+','+pageSize,new BeanListHandler<>(AirCompany.class) );
		
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
	}return null;
 }

// 删除数据
   public boolean deleteAirCompany(int[] cids){
	   Connection con=DBUtil.getConnection();
	   	QueryRunner qr=new QueryRunner();
	   try {
	       con.setAutoCommit(false);
	       for(int cid:cids){
	    	   qr.update(con," update  company join userlogin on company.Lid=userlogin.Lid set state=0,statem=0 where cid=?",cid);
	    	   
	    	   
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
   
   //修改公司信息
   public boolean modifyAirCompany(int cid,String inst_number,String com_name,String com_telnumber){
	   Connection con=DBUtil.getConnection();
	   QueryRunner qr=new QueryRunner();
	   try {
		   con.setAutoCommit(false);
		qr.update(con,"update company set inst_number=? ,com_name=? ,com_telnumber=? where cid=?",inst_number,com_name,com_telnumber,cid);
		
		   con.commit();
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
   //根据cid返回
    public AirCompany loadAirCompanybycid(int cid){
    	Connection con=DBUtil.getConnection();
    	QueryRunner qr=new QueryRunner();
    	AirCompany aircompany;
		try {
			aircompany = qr.query(con, "select * from company where cid=?",new BeanHandler<>(AirCompany.class),cid);
			return aircompany;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    return null;
    }
    //增加公司
    public boolean addAirCompany(String inst_number,String password,String com_name,String com_telnumber){
    	Connection connection=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rSet=null;
		QueryRunner queryRunner =new QueryRunner();
		try {
			connection.setAutoCommit(false);
			ps=connection.prepareStatement("insert into userlogin(username,password,statem,usertype) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, inst_number);
			ps.setString(2, password);
			ps.setInt(3, 1);
			ps.setInt(4,2 );
			ps.executeUpdate();
			rSet=ps.getGeneratedKeys();
			if(rSet.next()) {
				int Lid=rSet.getInt(1);
				queryRunner.update(connection,"insert into company(inst_number,com_name,com_telnumber,Lid,state) values(?,?,?,?,?)",inst_number,com_name,com_telnumber,Lid,1);
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
 