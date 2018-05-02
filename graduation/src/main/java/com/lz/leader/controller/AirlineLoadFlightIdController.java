package com.lz.leader.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Airport;
import com.lz.common.entity.FlightId;
import com.lz.leader.service.AirlineLoadFlightIdService;
import com.lz.leader.service.AirportMessageService;

import net.sf.json.JSONArray;
/**
 * 加载航班编号类
 * @author ASUS
 *
 */
@WebServlet("/loadFlightId/*")
public class AirlineLoadFlightIdController extends BaseController{
	//加载所有机场信息
	private AirlineLoadFlightIdService airlineLoadFlightIdService=new AirlineLoadFlightIdService();
	
	public void loadFlightId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=Integer.parseInt(req.getParameter("cid"));
		List<FlightId> flightIds=airlineLoadFlightIdService.loadFlightId(cid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(flightIds).toString());
		
		
	}
}
