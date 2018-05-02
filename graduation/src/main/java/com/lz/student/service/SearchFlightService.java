package com.lz.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.Flight;
import com.lz.student.dao.SearchFlightDao;

public class SearchFlightService {
	SearchFlightDao searchFlightDao = new SearchFlightDao();
	
	public Map<String,Object> searchFlightPage(int pageNum,int pageSize){
	int total = searchFlightDao.searchFlight().size();
	List<Flight> list = searchFlightDao.searchFlightPage(pageNum, pageSize);
	Map<String,Object> map = new HashMap<>();
	map.put("total", total);
	map.put("rows",list);
	return map;
	}
}
