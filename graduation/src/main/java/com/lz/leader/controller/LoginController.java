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
import com.lz.common.entity.AirCompany;
import com.lz.common.entity.User;
import com.lz.leader.service.AirlineCompanyMessageService;
import com.lz.leader.service.LoginService;

import sun.misc.BASE64Encoder;

@WebServlet("/Login/*")
public class LoginController extends BaseController{
	private LoginService loginService= new LoginService();
	private AirlineCompanyMessageService airlineCompanyMessageService=new AirlineCompanyMessageService();
	public void airlineLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		
		String password =req.getParameter("password");
		
		String usertype= req.getParameter("usertype");
		int type=Integer.parseInt(usertype);
		//密码加密处理
//		MessageDigest md5;
//		try {
//			md5=MessageDigest.getInstance("MD5");
//			BASE64Encoder base64Encoder=new BASE64Encoder();
//			password=base64Encoder.encode(md5.digest(password.getBytes()));
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
		//判断是否登陆正确
		User user = loginService.login(username, password);
		//根据结果执行操作
		if(user!=null) {			
			//根据不同用户类型执行不同页面跳转
			if(type==3){
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/view/managerindex.jsp").forward(req, resp);
			}else if(type==2) {
				req.getSession().setAttribute("user", user);
				AirCompany airCompany=airlineCompanyMessageService.loadCompanyMessageByLid(user.getLid());
				req.getSession().setAttribute("airCompany", airCompany);
				req.getRequestDispatcher("/view/airlineMain.jsp").forward(req, resp);
			}else{
				req.getSession().setAttribute("user", user);
				AirCompany airCompany=airlineCompanyMessageService.loadCompanyMessageByLid(user.getLid());
				req.getSession().setAttribute("airCompany", airCompany);
				req.getRequestDispatcher("/view/airlineMain.jsp").forward(req, resp);
			}
			
		}else {
			req.setAttribute("loginInfo", "用户名或密码错误！");
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
					
		}
	}
}
	


