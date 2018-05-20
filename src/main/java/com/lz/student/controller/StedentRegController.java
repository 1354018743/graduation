package com.lz.student.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.student.service.StudentRegService;

import net.sf.json.JSONObject;
@WebServlet(value="/studentReg/*")
public class StedentRegController extends BaseController {
	StudentRegService studentRegService=new StudentRegService();
	private static final long serialVersionUID = 1L;
	public void studentReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String studentno=req.getParameter("stuno");
		String sex=req.getParameter("sex");
		String departrue=req.getParameter("departrue");
		String grade=req.getParameter("grade");
			System.out.println(departrue);	
			boolean result;
			result=studentRegService.studentReg(name, email, studentno, departrue, grade);
			String s=result+"";
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(s);
		
	}
	

}
