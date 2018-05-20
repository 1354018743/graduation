package com.lz.manager.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.ApplyProgress;
import com.lz.leader.service.StudentApplyMessageService;
import com.lz.manager.service.ManagerRegService;
import com.lz.student.service.ApplyMessageService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/managerReg/*")
public class ManagerRegController extends BaseController{
	//加载所有注册信息
	public ManagerRegService mrs=new ManagerRegService();
	
	public void loadReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		Map<String,Object> map=mrs.loadReg(page, pageSize);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
		
	}
	//增加
	public void accessReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int regid=Integer.parseInt(req.getParameter("regid"));
		   	String studentno=req.getParameter("studentno");
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String departure=req.getParameter("departrue");
			String grade=req.getParameter("grade");	
			boolean result;
			result=mrs.accessReg(regid,studentno, name, email,departure,grade);
			String s=result+"";
			resp.getWriter().write(s);
	}
	
	public void modifyReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int regid=Integer.parseInt(req.getParameter("regid"));
		boolean result=mrs.modifyReg(regid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
}
