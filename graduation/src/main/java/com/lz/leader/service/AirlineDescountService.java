package com.lz.leader.service;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.commn.uitl.Condition;
import com.lz.common.entity.Descount;
import com.lz.common.entity.FlightMessage;
import com.lz.leader.dao.AirlineDescountDao;

public class AirlineDescountService {
	private AirlineDescountDao airlineDescountDao= new AirlineDescountDao();
	//加载所有优惠政策
	public Map<String,Object> loadAllDescount(int page,int rows,int cid){
		int total= airlineDescountDao.loadAllDescount(cid).size();
		List<Descount> descounts=airlineDescountDao.loadDescountByPage(page, rows, cid);
		Map<String, Object> map=new HashMap<>();
		map.put("total", total);
		map.put("rows", descounts);
		return map;
	}

	//增加优惠政策
	public boolean addDescount(int fid,double descount_1,double descount_2){
		return airlineDescountDao.addDescount(fid, descount_1,descount_2);
	}

	//修改优惠政策
	public boolean modifyDescount(int fid,double descount_1,double descount_2){
		return airlineDescountDao.modifyDescount(fid, descount_1,descount_2);
	}
	//根据条件查询折扣信息
	public Map<String, Object> searchDescount(String fid,String cid,String starttime,String endtime,String star_airportnumber,String end_airportnumber,String startprice_1,String endprice_1,String startprice_2,String endprice_2,int page,int rows){
		if(star_airportnumber.equals("-1")){
			star_airportnumber="";
		}
		if(end_airportnumber.equals("-1")){
			end_airportnumber="";
		}
		String sql="select f.fid,f.cid,d.did,"+
			"(select port_name from airport c where f.star_airportnumber=aid) as port_name,"+
			"(select port_name from airport d where f.end_airportnumber=aid) as end_port_name,"+
			"f.setouttime,f.achieve,price_1,descount_1,genre_1,price_2,descount_2,genre_2 "+
			"from flight f join airticket a on f.fid=a.fid join descount d on a.fid=d.fid "+
			"where state=1 ";
		Condition cu=new Condition(sql);
		cu.appendEquals(Condition.AND, "cid", cid, Types.INTEGER);
		cu.appendEquals(Condition.AND, "a.fid", fid, Types.INTEGER);
		cu.appendEquals(Condition.AND, "star_airportnumber", star_airportnumber, Types.INTEGER);
		cu.appendEquals(Condition.AND, "end_airportnumber", end_airportnumber, Types.INTEGER);
		cu.appendNoBigger(Condition.AND, "setouttime", endtime, Types.DATE);
		cu.appendNoSmailler(Condition.AND, "setouttime", starttime, Types.DATE);
		cu.appendNoBigger(Condition.AND, "price_1", endprice_1, Types.INTEGER);
		cu.appendNoSmailler(Condition.AND, "price_1", startprice_1, Types.INTEGER);
		cu.appendNoBigger(Condition.AND, "price_2", endprice_2, Types.INTEGER);
		cu.appendNoSmailler(Condition.AND, "price_2", startprice_2, Types.INTEGER);
		sql=cu.toString();
		int total=airlineDescountDao.searchAllDescount(sql).size();
		cu=new Condition(sql);
		cu.appendLimit(page, rows);
		List<Descount> descounts=airlineDescountDao.searchDescount(cu.toString());
		Map<String, Object> flMap=new HashMap<>();
		flMap.put("total", total);
		flMap.put("rows", descounts);
		return flMap;
	}
	

}
