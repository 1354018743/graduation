package com.lz.leader.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.leader.service.ModifyApplyService;
@WebServlet("/leaderApply/*")
//审核人员审核
public class ModifyApplyController extends BaseController{

	public ModifyApplyService mas= new ModifyApplyService();
	//审核人员通过审核信息
	public void accessApply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int aiid=Integer.parseInt(req.getParameter("aiid1"));
		boolean result=mas.accessApply(aiid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	
	public void modifyApply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int aiid=Integer.parseInt(req.getParameter("aiid1"));
		boolean result=mas.modifyApply(aiid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
}
