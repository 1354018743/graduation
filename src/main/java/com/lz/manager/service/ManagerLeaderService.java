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

import com.lz.common.entity.Leader;
import com.lz.manager.dao.ManagerLeaderDao;

import sun.misc.BASE64Encoder;

public class ManagerLeaderService {
		public ManagerLeaderDao mld=new ManagerLeaderDao();
	   public Map<String,Object> loadLeader(int page,int pageSize,String leaderno,String name){
			  int total=mld.queryAllLeader(leaderno,name).size();
			  List<Leader> rows=mld.queryPage(page, pageSize,leaderno,name);
			  Map<String,Object> map=new HashMap<>();
			  map.put("total", total);
			  map.put("rows", rows);
			  return map;
			   
		   }
	   public boolean modifyLeaderPower(int rank,int leaderid){
			  
			  return mld.modifyLeaderPower(rank,leaderid);
			   
		   }
	   //删除数据
	   public boolean deleteLeaders(String leaderids){
		   String leaderidStr[]=leaderids.split(",");
			int[] leaderid_1=new int[leaderidStr.length];
			for(int i=0;i<leaderidStr.length;i++){
				leaderid_1[i]= Integer.parseInt(leaderidStr[i]);
			}
			return mld.deleteLeader(leaderid_1);
		}

	public boolean addLeader(String leaderno,String name, String job,String departure,String workplace,String phone,int rank){
	    	MessageDigest md5;
	    	String password=null;
	    	BASE64Encoder base64Encoder=new BASE64Encoder();
			try {
				md5=MessageDigest.getInstance("MD5");
			
				
				password=base64Encoder.encode(md5.digest(leaderno.getBytes()));
		    	
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			return mld.addLeader(leaderno,password, name, job,departure,workplace,phone,rank);
	    }
}