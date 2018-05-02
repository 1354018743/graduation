package com.lz.manager.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.manager.service.PassengerService;

import net.sf.json.JSONObject;
@WebServlet(value="/managerpassenger/*")
public class PassengerController extends BaseController {
	PassengerService passengerService=new PassengerService();
	public void loadPassenger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int pageNum=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		String realname=req.getParameter("realname");
		String cardid=req.getParameter("cardid");
		String tel_number=req.getParameter("tel_number");
		String email=req.getParameter("email");
		Map<String,Object> map =passengerService.loadPassenger(pageNum, pageSize,realname,cardid,tel_number,email);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	
public void deletePassenger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pids=req.getParameter("pids");
		boolean result;
		result=passengerService.deletePassenger(pids);
		String s=result+"";
		resp.getWriter().write(s);
	} 

}
