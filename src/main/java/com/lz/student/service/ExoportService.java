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

import com.lz.common.entity.Apply;
import com.lz.common.entity.ApplyProgress;
import com.lz.student.dao.ApplyMessageDao;
import com.lz.student.dao.ExportDao;

public class ExoportService {
		public ExportDao ed=new ExportDao();
	   public List<Apply>  loadApply(int aid){
			
			  return ed.queryApply(aid);
			   
		   }
}