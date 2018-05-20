package com.lz.leader.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Leader;
import com.lz.leader.service.LeaderMessageService;
@WebServlet("/leaderMessage/*")
//航空公司信息处理类
public class LeaderMessageController extends BaseController{

	//修改审核人员信息
	public LeaderMessageService lms= new LeaderMessageService();
	public void modifyLeaderMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int leaderid=Integer.parseInt(req.getParameter("leaderid"));
		String name=req.getParameter("name");
		System.out.println(name);
		String leaderno =req.getParameter("leaderno");
		String job =req.getParameter("job");
		String departure =req.getParameter("departure");
		String workplace =req.getParameter("workplace");
		String phone =req.getParameter("phone");
		boolean result=lms.modifyLeaderMessage(leaderid, name, leaderno, job, departure, workplace, phone);
		if(result){
			HttpSession session=req.getSession();
			Leader leader=(Leader)session.getAttribute("leader");
			leader.setName(name);
			leader.setLeaderno(leaderno);
			leader.setJob(job);
			leader.setDeparture(departure);
			leader.setWorkplace(workplace);
			leader.setPhone(phone);
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
}
