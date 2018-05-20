package com.lz.leader.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.lz.common.entity.User;
import com.lz.leader.dao.LeaderChangPasswordDao;
import com.lz.manager.dao.ManagerChangPasswordDao;

import sun.misc.BASE64Encoder;

public class LeaderChangePasswordService {
	LeaderChangPasswordDao lcp=new LeaderChangPasswordDao();
	
	//检查原密码是否输入正确
	public boolean checkPassword(String password,int lid){
		User user=lcp.checkPassword(lid);
		MessageDigest md5;
		try {
			md5=MessageDigest.getInstance("md5");
			BASE64Encoder base64encoder=new BASE64Encoder();
			password= base64encoder.encode(md5.digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(user.getPassword().equals(password)){
			return true;
			
		}
		return false;
	}
   public boolean updateManagerPassword(int Lid,String password){
	   return  lcp.updatePassword(Lid, password);
	   
   }
}
