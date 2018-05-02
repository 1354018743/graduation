package com.lz.leader.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.User;
import com.lz.leader.service.ModifyPasswordService;
@WebServlet("/companypassword/*")
	public class ModifyPasswordController extends BaseController{
		ModifyPasswordService modifyPasswordService=new ModifyPasswordService();
	//验证原密码是否输入正确
	public void ModifyPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		int lid=user.getLid();
		 boolean result=modifyPasswordService.checkPassword(password,lid);
		 resp.getWriter().write(result+"");	
	}
	//修改新的密码
	public void ChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		int lid=user.getLid();
		 boolean result=modifyPasswordService.changePassword(password,lid);
		 resp.getWriter().write(result+"");
	}

}
