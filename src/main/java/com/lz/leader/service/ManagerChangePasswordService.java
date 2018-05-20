package com.lz.leader.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.lz.common.entity.User;
import com.lz.manager.dao.ManagerChangPasswordDao;

import sun.misc.BASE64Encoder;

public class ManagerChangePasswordService {
	ManagerChangPasswordDao mcpd=new ManagerChangPasswordDao();
	
	public  String getPasswordByMD5(int Lid){
	 User user=mcpd.getUserbylid(Lid);
	 
	String password=user.getPassword();
	 
	 return password;
	
		
	}
   public boolean updateManagerPassword(int Lid,String password){
	   return  mcpd.updatePassword(Lid, password);
	   
   }
}
