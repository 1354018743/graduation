package com.lz.manager.service;
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
import com.lz.leader.dao.StudentApplyMessageDao;
import com.lz.student.dao.ApplyMessageDao;

public class StudentApplyMessageService {
		public StudentApplyMessageDao smd=new StudentApplyMessageDao();
	   public Map<String,Object> loadApplyProgress(int page,int pageSize,int lid,String sno,String sname){
			  int total=smd.queryApplyMessage(lid,sno,sname).size();
			  List<ApplyProgress> rows=smd.queryPage(page, pageSize,lid,sno,sname);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
}