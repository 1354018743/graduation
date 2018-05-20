package com.lz.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Leader;
import com.lz.common.entity.Student;
import com.lz.leader.service.LeaderMessageService;
@WebServlet("/StudentMessage/*")
//航空公司信息处理类
public class StudentMessageController extends BaseController{

	//修改审核人员信息
	public StudentMessageService sms= new StudentMessageService();
	public void modifyStudentMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid=Integer.parseInt(req.getParameter("sid"));
		String name=req.getParameter("name");
		String departure =req.getParameter("departure");
		String grade =req.getParameter("grade");
		String email =req.getParameter("email");
		boolean result=sms.modifyStudentMessage(sid, name, departure, grade, email);
		if(result){
			HttpSession session=req.getSession();
			Student student=(Student)session.getAttribute("student");
			student.setName(name);
			student.setDeparture(departure);
			student.setGrade(grade);
			student.setEmail(email);
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
}
