package com.lz.leader.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.AirCompany;
import com.lz.leader.service.AirlineCompanyMessageService;
@WebServlet("/airlineCompanyMessage/*")
//航空公司信息处理类
public class AirlineCompanyMessageController extends BaseController{

	private AirlineCompanyMessageService airlineCompanyMessageService= new AirlineCompanyMessageService(); 
	//修改航空公司信息
	public void modifyCompanyMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inst_number=req.getParameter("inst_number");
		String com_name =req.getParameter("com_name");
		String com_telnumber =req.getParameter("com_telnumber");
		boolean result=airlineCompanyMessageService.modifyCompanyMessage(inst_number,com_name,com_telnumber);
		if(result){
			HttpSession session=req.getSession();
			AirCompany airCompany=(AirCompany)session.getAttribute("airCompany");
			airCompany.setCom_name(com_name);
			airCompany.setCom_telnumber(com_telnumber);
		}
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
}
