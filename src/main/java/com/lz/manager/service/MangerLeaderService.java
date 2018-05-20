package com.lz.manager.service;
/**
 * 机场信息的处理
 * @author ASUS
 *
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.ApplyProgress;
import com.lz.common.entity.Leader;
import com.lz.manager.dao.ManagerLeaderDao;

public class MangerLeaderService {
		public ManagerLeaderDao mld=new ManagerLeaderDao();
	   public Map<String,Object> loadApplyProgress(int page,int pageSize,String leaderno,String name){
			  int total=mld.queryAllLeader(leaderno,name).size();
			  List<Leader> rows=mld.queryPage(page, pageSize,leaderno,name);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
}