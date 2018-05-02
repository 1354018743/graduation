package com.lz.student.service;

import java.util.List;

import com.lz.common.entity.Passenger;
import com.lz.student.dao.UserMessageDao;

public class UserMessageService {
	
	private UserMessageDao userMessageDao = new UserMessageDao();
	
	public List<Passenger> loadUserMessage(String username,String password){
		return userMessageDao.loadUserMessage(username, password);
	}
	
	public boolean queryUserMessage(Passenger passenger){
		return userMessageDao.queryUserMessage(passenger);
	}

}
