package com.lz.leader.service;


import com.lz.common.entity.User;
import com.lz.leader.dao.LoginDao;

public class LoginService {
	private LoginDao userDao = new LoginDao();
	//用户登录信息判断  state=0表示不可登录
	public  User login(String username,String password,int usertype) {
		User user = userDao.getUserByName(username,usertype);
		
		if(user==null) {
			return null;
		}else if(!(user.getPassword().equals(password)&&user.getStatem().equals("1"))) {
			return null;
		}
		return user;
	}
	
}
