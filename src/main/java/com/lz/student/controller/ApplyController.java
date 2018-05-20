package com.lz.student.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Student;
import com.lz.student.service.ApplyUploadService;

import sun.misc.BASE64Encoder;

@WebServlet("/ApplyUpload/*")
public class ApplyController extends BaseController{
	public ApplyUploadService aus=new ApplyUploadService();
	public void applyUpload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		int population =Integer.parseInt(req.getParameter("population"));
		String contry =req.getParameter("country");
		String allowances =req.getParameter("allowances");
		String ranking =req.getParameter("ranking");
		String principle =req.getParameter("principle");
		String subsidize =req.getParameter("subsidize");
		String spending =req.getParameter("spending");
		String work =req.getParameter("work");
		HttpSession session=req.getSession();
		Student student=(Student)session.getAttribute("student");
		String name=student.getName();
		String studentno = student.getStuno();
		int lid=student.getLid();
		boolean result=aus.addApply(studentno,name,lid,population, contry, allowances, ranking, principle, subsidize, spending, work);
		String s=result+"";
    	resp.getWriter().write(s);;
	}
}
	


