package com.lz.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.Order;
import com.lz.common.entity.Passenger;
import com.lz.student.dao.searchOrderDao;

public class searchOrderService {
	private searchOrderDao searchOrderDao = new searchOrderDao();
	public Map<String,Object> loadOrderPage(int pageNum,int pageSize){
		//查总数
		int total = searchOrderDao.searchOrder().size();
		//查当前页面
		List<Order> list = searchOrderDao.searchOrderPage(pageNum, pageSize);
		Map<String,Object> map = new HashMap<>();
		map.put("total",total);
		map.put("rows",list);
		return map;
	}
}
