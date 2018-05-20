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

import com.lz.common.entity.Student;
import com.lz.common.entity.Student;
import com.lz.manager.dao.ManagerStudentDao;

import sun.misc.BASE64Encoder;

public class ManagerStudentService {
		public ManagerStudentDao msd=new ManagerStudentDao();
	   public Map<String,Object> loadStudent(int page,int pageSize,String stuno,String name){
			  int total=msd.queryAllStudent(stuno,name).size();
			  List<Student> rows=msd.queryPage(page, pageSize,stuno,name);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
	   public boolean modifyStudentPower(int rank,int Studentid){
			  
			  return msd.modifyStudentPower(rank,Studentid);
			   
		   }
	   //删除数据
	   public boolean deleteStudents(String sids){
		   String sidStr[]=sids.split(",");
			int[] sid_1=new int[sidStr.length];
			for(int i=0;i<sidStr.length;i++){
				sid_1[i]= Integer.parseInt(sidStr[i]);
			}
			return msd.deleteStudent(sid_1);
		}

	public boolean addStudent(String stuno,String name, String departure,String grade,String email){
	    	MessageDigest md5;
	    	String password=null;
	    	BASE64Encoder base64Encoder=new BASE64Encoder();
			try {
				md5=MessageDigest.getInstance("MD5");
			
				
				password=base64Encoder.encode(md5.digest(stuno.getBytes()));
		    	
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			return msd.addStudent(stuno,password, name,departure,grade,email);
	    }
}