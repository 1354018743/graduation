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
import com.lz.manager.dao.MStudentApplyMessageDao;
public class MStudentApplyMessageService {
		public MStudentApplyMessageDao smd=new MStudentApplyMessageDao();
	   public Map<String,Object> loadApplyProgress(int page,int pageSize,String sno,String sname){
			  int total=smd.queryApplyMessage(sno,sname).size();
			  List<ApplyProgress> rows=smd.queryPage(page, pageSize,sno,sname);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
}