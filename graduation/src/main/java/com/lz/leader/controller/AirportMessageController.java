package com.lz.leader.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Airport;
import com.lz.leader.service.AirportMessageService;

import net.sf.json.JSONArray;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/airportMessage/*")
public class AirportMessageController extends BaseController{
	//加载所有机场信息
	private AirportMessageService airportMessageService= new AirportMessageService();
	
	public void loadAirportMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Airport> airports=airportMessageService.loadAirport();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(airports).toString());
		
		
	}
}
