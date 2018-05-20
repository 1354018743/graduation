package com.lz.student.service;

import com.lz.common.entity.User;
import com.lz.student.dao.ChangePasswordDao;

public class ChangePasswordService {
		ChangePasswordDao cpd=new ChangePasswordDao();
	   public boolean updatePassword(int Lid,String password){
		   return  cpd.updatePassword(Lid, password);
		   
	   }
	   
		public  String getPasswordByMD5(int Lid){
			 User user=cpd.getUserbylid(Lid);
			 
			String password=user.getPassword();
			 
			 return password;
			
				
			}

}
