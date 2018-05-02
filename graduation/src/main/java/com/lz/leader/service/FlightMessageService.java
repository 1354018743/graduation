package com.lz.leader.service;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.commn.uitl.Condition;
import com.lz.common.entity.FlightMessage;
import com.lz.leader.dao.FlightMessageDao;

/**
 * 航班信息处理类
 * @author ASUS
 *
 */
public class FlightMessageService {
	
	private FlightMessageDao flightMessageDao=new FlightMessageDao();
	//分页加载航班信息
	public Map<String, Object> loadFlightMessage(int pag,int rows,int cid) {
		int total= flightMessageDao.loadAllFlightMessage(cid).size();
		List<FlightMessage> flightMessages=flightMessageDao.loadFlightMessageByPag(pag, rows, cid);
		Map<String, Object> flMap=new HashMap<>();
		flMap.put("total", total);
		flMap.put("rows", flightMessages);
		return flMap;
	}
	//增加航班信息
	public boolean addFlight(String air_number,Date setouttime,Date achieve,int cid,int star_airportnumber,int end_airportnumber,double price_1,int pricecount_1,String genre_1,double price_2,int pricecount_2,String genre_2) {
		return flightMessageDao.addFlight(air_number,setouttime,achieve,cid,star_airportnumber,end_airportnumber,price_1,pricecount_1,genre_1,price_2,pricecount_2,genre_2);
	}

	//删除航班
	public boolean deleteFlightMessage(String fids) {
		String[] fidStr=fids.split(",");
		int[] fid=new int[fidStr.length];
		for(int i=0;i<fidStr.length;i++){
			fid[i]=Integer.parseInt(fidStr[i]);
		}
		return flightMessageDao.deleteFlightMessage(fid);
	}
	//修改航班
	public boolean modifyFlightMessage(int fid,String air_number,Date setouttime,Date achieve,double price_1,int pricecount_1,double price_2,int pricecount_2) {
		return flightMessageDao.modifyFlightMessage(fid,air_number,setouttime,achieve,price_1,pricecount_1,price_2,pricecount_2);
	}
	//根据条件查询航班信息
	public Map<String, Object> searchFlightMessage(String air_number,String cid,String starttime,String endtime,String star_airportnumber,String end_airportnumber,String startprice_1,String endprice_1,String startprice_2,String endprice_2,int page,int rows){
		if(star_airportnumber.equals("-1")){
			star_airportnumber="";
		}
		if(end_airportnumber.equals("-1")){
			end_airportnumber="";
		}
		String sql="select  a.fid,a.air_number,a.setouttime,a.achieve,a.cid,"
				+"(select port_name from airport c where a.star_airportnumber=c.aid) as port_name,"
				+"(select port_name from airport d where a.end_airportnumber=d.aid) as end_port_name,"
				+"a.state,b.price_1,b.pricecount_1,b.genre_1,b.price_2,b.pricecount_2,b.genre_2  "
				+"from flight a join airticket b on a.fid=b.fid "
				+"where state=1 ";
		Condition cu=new Condition(sql);
		cu.appendEquals(Condition.AND, "cid", cid, Types.INTEGER);
		cu.appendLike(Condition.AND, "air_number", air_number);
		cu.appendEquals(Condition.AND, "star_airportnumber", star_airportnumber, Types.INTEGER);
		cu.appendEquals(Condition.AND, "end_airportnumber", end_airportnumber, Types.INTEGER);
		cu.appendNoBigger(Condition.AND, "setouttime", endtime, Types.DATE);
		cu.appendNoSmailler(Condition.AND, "setouttime", starttime, Types.DATE);
		cu.appendNoBigger(Condition.AND, "price_1", endprice_1, Types.INTEGER);
		cu.appendNoSmailler(Condition.AND, "price_1", startprice_1, Types.INTEGER);
		cu.appendNoBigger(Condition.AND, "price_2", endprice_2, Types.INTEGER);
		cu.appendNoSmailler(Condition.AND, "price_2", startprice_2, Types.INTEGER);
		sql=cu.toString();
		int total=flightMessageDao.searchAllFlightMessage(sql).size();
		cu=new Condition(sql);
		cu.appendLimit(page, rows);
		List<FlightMessage> flightMessages=flightMessageDao.searchFlightMessage(cu.toString());
		Map<String, Object> flMap=new HashMap<>();
		flMap.put("total", total);
		flMap.put("rows", flightMessages);
		return flMap;
	}
}
