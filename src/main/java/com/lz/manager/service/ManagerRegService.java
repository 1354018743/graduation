package com.lz.manager.service;
/**
 * 机场信息的处理
 * @author ASUS
 *
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.Reg;
import com.lz.manager.dao.ManagerRegDao;

import sun.misc.BASE64Encoder;

public class ManagerRegService {
		public ManagerRegDao mrd=new ManagerRegDao();
	   public Map<String,Object> loadReg(int page,int pageSize){
			  int total=mrd.queryAllCompany().size();
			  List<Reg> rows=mrd.queryPage(page, pageSize);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
		public boolean accessReg(int regid,String studentno,String name, String email,String departure,String grade){
	    	MessageDigest md5;
	    	String password=null;
	    	BASE64Encoder base64Encoder=new BASE64Encoder();
			try {
				md5=MessageDigest.getInstance("MD5");
			
				
				password=base64Encoder.encode(md5.digest(studentno.getBytes()));
		    	
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			return mrd.accessReg(regid,studentno,password, name, email,departure,grade);
	    }
		public boolean modifyReg(int regid){

			return mrd.modifyReg(regid);
			
		}
}