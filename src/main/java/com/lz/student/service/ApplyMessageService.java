package com.lz.student.service;
/**
 * 机场信息的处理
 * @author ASUS
 *
 */

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.ApplyProgress;
import com.lz.student.dao.ApplyMessageDao;

public class ApplyMessageService {
		public ApplyMessageDao applyMessageDao=new ApplyMessageDao();
	   public Map<String,Object> loadApplyProgress(int page,int pageSize,int lid){
			  int total=applyMessageDao.queryAllCompany(lid).size();
			  List<ApplyProgress> rows=applyMessageDao.queryPage(page, pageSize,lid);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
}