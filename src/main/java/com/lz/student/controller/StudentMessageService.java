package com.lz.student.controller;

import com.lz.common.entity.Student;
import com.lz.student.dao.StudentMessageDao;
//审核人员信息
public class StudentMessageService {
	public StudentMessageDao smd=new StudentMessageDao();
	//根据登录号加载学生人员信息
	public Student loadStudentMessageByLid(int lid) {
		return smd.loadStudentMessageByLid(lid);
	}
	//修改学生人员信息
	public boolean modifyStudentMessage(int sid,String name,String departure,String grade,String email) {
		return smd.modifyStudentMessage(sid,name,departure,grade,email);
	}

}
