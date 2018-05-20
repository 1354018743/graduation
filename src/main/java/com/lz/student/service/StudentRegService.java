package com.lz.student.service;

import com.lz.student.dao.StudentRegDao;

public class StudentRegService {
	StudentRegDao studentRegDao=new StudentRegDao();
	
	public boolean studentReg( String name,String email,String studentno,String departure,String grade){
		
		return studentRegDao.studentReg(name, email, studentno,departure,grade);
		
	}

}
