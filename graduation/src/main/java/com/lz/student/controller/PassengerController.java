package com.lz.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Passenger;
import com.lz.student.service.SearchFlightService;
import com.lz.student.service.UserMessageService;
import com.lz.student.service.searchOrderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet("/passenger/*")
public class PassengerController extends BaseController{
	private static final long serialVersionUID = 1L;

	private SearchFlightService searchflightService = new SearchFlightService();
	/**
	 * 加载所有航班信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void searchFlight(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		Map<String,Object> map = searchflightService.searchFlightPage(page,rows);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}	
	
	private searchOrderService searchorderService = new searchOrderService();
	/**
	 * 加载所有订单信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void searchOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		Map<String,Object> map = searchorderService.loadOrderPage(page,rows);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
	}
	
	
	//个人信息查询
	private UserMessageService userMessageService = new UserMessageService();
	
	public void loadUserMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Passenger passenger = (Passenger)req.getSession().getAttribute("passenger");
		String username = passenger.getUsername();
		String password = passenger.getPassword();
		List<Passenger> passengerList = userMessageService.loadUserMessage(username, password);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(passengerList).toString());

	}
	
	public void queryUserMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Passenger passenger = (Passenger)req.getSession().getAttribute("passenger");
		boolean querySccess=false;
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(querySccess).toString());
	}
}

