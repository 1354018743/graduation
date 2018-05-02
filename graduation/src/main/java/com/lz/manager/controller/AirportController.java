package com.lz.manager.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Airport;
import com.lz.manager.service.AirportService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet(value="/managerairport/*")
public class AirportController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * ���طɻ���
	 */
	AirportService airportService=new AirportService();
	public void loadAirport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		String port_number=req.getParameter("port_number");
		String port_name=req.getParameter("port_name");
		String city=req.getParameter("city");
		
	
		Map<String,Object> map =airportService.loadAirport(pageNum, pageSize,port_number,port_name,city);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
	} 
	/**
	 * 
	 * ��֤�ɻ���
	 * 
	 * 
	 */
	
	
	public void isHaveAirport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String port_number=req.getParameter("port_number");
		String port_name=req.getParameter("port_name");
		String city=req.getParameter("city");
		
	
		List<Airport> list =airportService.isHaveAirport(port_number,port_name,city);
		Airport A=list.get(0);
		 String num=A.getPort_number();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(num);
		
	} 
	/**
	 * 
	 * ��ӷɻ���
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addAirport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String port_number=req.getParameter("port_number");
		String port_name=req.getParameter("port_name");
		String city=req.getParameter("city");
		boolean result;
		result=airportService.addAirport(port_number,port_name,city);
		String s=result+"";
		resp.getWriter().write(s);
	} 
public void deleteAirport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String aids=req.getParameter("aids");
		boolean result;
		result=airportService.deleteAirport(aids);
		String s=result+"";
		resp.getWriter().write(s);
	} 
/*
 * 
 * �޸Ļ�����Ϣ
 */
public void modifyAirport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int aid=Integer.parseInt(req.getParameter("aid"));
	String port_number=req.getParameter("port_number");
	String port_name=req.getParameter("port_name");
	String city=req.getParameter("city");
	boolean result;
	result=airportService.modifyAirport(aid,port_number,port_name,city);
	String s=result+"";
	resp.getWriter().write(s);
} 

public void loadAirportByAid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int aid=Integer.parseInt(req.getParameter("aid"));
	boolean result;

    Airport airport=airportService.loadAirportByAid(aid);
	
	resp.setCharacterEncoding("utf-8");
	resp.getWriter().write(JSONArray.fromObject(airport).toString());
}
public void searchAirport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String port_name=req.getParameter("port_name");
	String port_number=req.getParameter("port_number");
	String city=req.getParameter("city");
    
    List<Airport> list=airportService.searchAirport(port_number, port_name, city);
	resp.setCharacterEncoding("utf-8");
	
	resp.getWriter().write(JSONArray.fromObject(list).toString());
}
}
