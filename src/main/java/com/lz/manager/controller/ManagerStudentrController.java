package com.lz.manager.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Student;
import com.lz.manager.service.ManagerStudentService;

import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/managerStudent/*")
public class ManagerStudentrController extends BaseController{
	//加载所有机场信息
	public ManagerStudentService mss=new ManagerStudentService();
	
	public void loadStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		String Studentno=req.getParameter("sno");
		String name=req.getParameter("sname");
		Map<String,Object> map=mss.loadStudent(page, pageSize,Studentno,name);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
		
	}
	public void modifyStudentPower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rank=Integer.parseInt(req.getParameter("power"));
		int Studentid=Integer.parseInt(req.getParameter("Studentid"));
		System.out.println(Studentid);
		boolean result=mss.modifyStudentPower(rank,Studentid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	//删除审核人员
public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String sids=req.getParameter("sids");
	
	boolean result;
	result=mss.deleteStudents(sids);
	String s=result+"";
	resp.getWriter().write(s);	

}
//增加
public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   	String stuno=req.getParameter("stuno");
		String name=req.getParameter("sname");
		String departure=req.getParameter("departure1");
		String grade=req.getParameter("grade");
		String email=req.getParameter("email");	
		boolean result;
		result=mss.addStudent(stuno, name, departure,grade,email);
		String s=result+"";
		resp.getWriter().write(s);
}
}
