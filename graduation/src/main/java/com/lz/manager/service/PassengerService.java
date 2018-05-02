package com.lz.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.User1;
import com.lz.manager.dao.PassengerDao;

public class PassengerService {
	
	PassengerDao passengerDao=new PassengerDao();
	public Map<String,Object> loadPassenger(int pageNum,int pageSize,String realname,String cardid,String tel_number,String email){
		int total=passengerDao.allPassenger(realname,cardid,tel_number,email).size();
		List<User1> rows=passengerDao.loadPassenger(pageNum, pageSize,realname,cardid,tel_number,email);
		Map<String,Object> map = new HashMap<>();
		map.put("total",total);
		map.put("rows",rows);
		return map;
		
		
		
	}
	
	
	public boolean deletePassenger(String pids){
		  
		String pidStr[]=pids.split(",");
		int[] pid_1=new int[pidStr.length];
		for(int i=0;i<pidStr.length;i++){
			pid_1[i]= Integer.parseInt(pidStr[i]);
			
			
		}
		
		return passengerDao.deletePassenger(pid_1);
	}

}
