package com.lz.leader.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Leader;
import com.lz.common.entity.Student;
import com.lz.common.entity.User;
import com.lz.leader.service.LeaderMessageService;
import com.lz.leader.service.LoginService;
import com.lz.student.controller.StudentMessageService;

import sun.misc.BASE64Encoder;

@WebServlet("/Login/*")
public class LoginController extends BaseController{
	private LoginService loginService= new LoginService();
	public  LeaderMessageService leaderMessageService=new LeaderMessageService();
	public  StudentMessageService sms=new StudentMessageService();
	@SuppressWarnings("restriction")
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("form-username");
		
		String password =req.getParameter("form-password");
		
		String usertype= req.getParameter("usertype");
		int type=Integer.parseInt(usertype);
		//密码加密处理
		MessageDigest md5;
		try {
			md5=MessageDigest.getInstance("MD5");
			@SuppressWarnings("restriction")
			BASE64Encoder base64Encoder=new BASE64Encoder();
			password=base64Encoder.encode(md5.digest(password.getBytes()));
			System.out.println(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//判断是否登陆正确
		User user = loginService.login(username,password,type);
		//根据结果执行操作
		if(user!=null) {			
			//根据不同用户类型执行不同页面跳转
			if(type==1){
				req.getSession().setAttribute("user", user);
				Student student =sms.loadStudentMessageByLid(user.getLid());
				req.getSession().setAttribute("student", student);
				req.getRequestDispatcher("/view/student/main.jsp").forward(req, resp);
			}else if(type==2) {
				req.getSession().setAttribute("user", user);
				
				Leader leader=leaderMessageService.loadLeaderMessageByLid(user.getLid());
				req.getSession().setAttribute("leader", leader);
				req.getRequestDispatcher("/view/leader/leaderMain.jsp").forward(req, resp);
			}else if(type==3){
				req.getSession().setAttribute("user", user);
				
				
				req.getRequestDispatcher("/view/manager/managerindex.jsp").forward(req, resp);
			}
			
		}else {
		//	req.setAttribute("loginInfo", "用户名或密码错误！");
		//	req.getRequestDispatcher("/login.jsp").forward(req, resp);
			resp.sendRedirect("/graduation/login.jsp");  
					
		}
	}
}
	


