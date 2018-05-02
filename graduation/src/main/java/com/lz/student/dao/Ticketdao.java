package com.lz.student.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.entity.Airticket;
import com.lz.common.entity.FlightMessage;
import com.lz.common.entity.Order;
import com.lz.common.entity.Passenger;
import com.lz.common.entity.Ticketsxs;

public class Ticketdao {
	private static final Long serialVersionUID=1L;
    /*
     *  加载所有的票
     * */
	public List<Ticketsxs> queryAllTickets() {
    	Connection con=DBUtil.getConnection();
    	QueryRunner qr =new QueryRunner();
    	try {
			List<Ticketsxs> list=qr.query(con, "select* from airticket", new BeanListHandler<>(Ticketsxs.class));
            return list;		
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return null;
    	
    } 
    /*
     * 分页查询所有票的信息
     * */
    public List<Ticketsxs> queryAllTicketspage(int pageNum,int pagesize){
    	Connection con=DBUtil.getConnection();
    	QueryRunner qr =new QueryRunner();
    	try {
    	
			List<Ticketsxs> list= qr.query(con, "select com_name,setouttime,achieve,a.port_name ,a1.port_name,price_2,price_1 ,pricecount_2,pricecount_1 from  airticket air JOIN flight f ON air.fid=f.fid join airport a on f.star_airportnumber=a.aid join airport a1 on f.end_airportnumber=a1.aid  JOIN company com ON f.cid=com.cid limit "+(pageNum-1)*pagesize+","+pagesize, new BeanListHandler<>(Ticketsxs.class));
            System.out.println(list.size());
			return list;		
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
		return null;
    	
    	
    	
    	
    }
    
   /*
    * 分页查询票信息
    * 
    * */
    public List<Airticket> queryAllticketPage(String sql){
		Connection con = DBUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			List<Airticket> list = qr.query(con, sql, new BeanListHandler<>(Airticket.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(null, null, con);
		}
		return null;
	}
    /*
     * 根据城市得到机场编号
     * */
    public int[] queryairpotidbysity(String sity) {
    	int[] airpotid=null;
    	Connection con=DBUtil.getConnection();
    	PreparedStatement pre=null;
    	ResultSet re=null;
    	int i=0;
    	try {
    	  pre=con.prepareStatement("SELECT port_number FROM airport WHERE city=? ");
    	  pre.setString(1, sity);
    	  re=pre.executeQuery();
          while(re.next()) {
        	 airpotid[i]=re.getInt(i);
        	 i=i+1;
          }   
    	  return airpotid;		
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(null, null, con);
		}
      return airpotid;	
    }
}
