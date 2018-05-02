package com.lz.student.service;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.commn.uitl.Condition;
import com.lz.common.entity.Airticket;
import com.lz.common.entity.FlightMessage;
import com.lz.common.entity.Ticketsxs;
import com.lz.student.dao.Ticketdao;

import net.sf.json.JSONObject;

public class Ticketservice {
	/*
	 *  /*
     * 加载所有的票
     * */
	
	private Ticketdao ticketdao=new Ticketdao();
		public Map<String,Object> loadTicketPage(int pageNum,int pagesize,String  startplace,String endplace,String danchengtime,String wanfantime){
			//调用dao处理出发地和到达地
			System.out.println(startplace);
			  int[] startid=ticketdao.queryairpotidbysity(startplace);
			  System.out.println(startid[0]);
			  int[] endid=ticketdao.queryairpotidbysity(endplace);
			//拼接sql语句
			String sql = "select com.com_name ,f.setouttime, f.achieve ,a.port_name ,a1.port_name, air.price_1,air.price_2 ,air.pricecount_1,air.pricecount_1 from  airticket air JOIN flight f ON air.fid=f.fid join airport a on f.star_airportnumber=a.aid join airport a1 on f.end_airportnumber=a1.aid  JOIN company com ON f.cid=com.cid ";
			Condition cu = new Condition(sql);
			String value1="";
			String value2="";
			 
			for( int i=0;i<startid.length;i++) {
				if(i==0) {
				  value1="("+" fid="+startid[i];
				}
				 value1=value1+" or fid="+startid[i]+" ";
				
				if(i==startid.length-1) {
				  value1=value1+"or fid="+startid[i]+")";
				}
			}
			 
			for( int j=0;j<endid.length;j++) {
				if(j==0) {
				  value2="("+" fid="+endid[j];
				}
				 value2=value2+" or fid="+endid[j]+" ";
				
				if(j==endid.length-1) {
				  value2=value2+"or fid="+endid[j]+")";
				}
			}
			 cu.appendEquals(Condition.AND,value1,"1",Types.BOOLEAN);
			 cu.appendEquals(Condition.AND,value2,"1", Types.BOOLEAN);
			 cu.appendEquals(Condition.AND,"setouttime",danchengtime, Types.DATE);
			 cu.appendEquals(Condition.OR,"setouttime",wanfantime, Types.DATE);
			 System.out.println(cu.toString());
			//查总数量
			 int total= ticketdao.queryAllticketPage(cu.toString()).size();
			//查当前页
			 List<Ticketsxs> list=ticketdao.queryAllTicketspage(pageNum, pagesize);
			 Map<String,Object> map=new HashMap<>();
			 map.put("rows", list);
			 map.put("total", total);
			 return map;
		}
		
		public JSONObject loadAllTickts(int pageNum,int pagesize){
			//查总数量
			 int total= ticketdao.queryAllTickets().size();
			//查当前页
			 List<Ticketsxs> list=ticketdao.queryAllTicketspage(pageNum, pagesize);
			JSONObject json=new JSONObject();
			json.put("total", total);
			json.put("rows", list);
	     return json;
		 }
		}


