package com.lz.manager.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Leader;
import com.lz.manager.service.ManagerLeaderService;

import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/managerLeader/*")
public class ManagerLeaderController extends BaseController{
	//加载所有机场信息
	public ManagerLeaderService mls=new ManagerLeaderService();
	
	public void loadLeader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		String leaderno=req.getParameter("lno");
		String name=req.getParameter("lname");
		Map<String,Object> map=mls.loadLeader(page, pageSize,leaderno,name);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
		
	}
	public void modifyLeaderPower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rank=Integer.parseInt(req.getParameter("power"));
		int leaderid=Integer.parseInt(req.getParameter("leaderid"));
		System.out.println(leaderid);
		boolean result=mls.modifyLeaderPower(rank,leaderid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	//删除审核人员
public void deleteLeader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String leaderids=req.getParameter("leaderids");
	
	boolean result;
	result=mls.deleteLeaders(leaderids);
	String s=result+"";
	resp.getWriter().write(s);	

}
//增加
public void addLeader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   	String leaderno=req.getParameter("leaderno1");
		String name=req.getParameter("name1");
		String job=req.getParameter("job1");
		String workplace=req.getParameter("workplace1");
		String departure=req.getParameter("departure1");
		String phone=req.getParameter("phone1");	
		int rank=Integer.parseInt(req.getParameter("type1"));
		System.out.println(leaderno);
		boolean result;
		result=mls.addLeader(leaderno, name, job,departure,workplace,phone,rank);
		String s=result+"";
		resp.getWriter().write(s);
}
}
