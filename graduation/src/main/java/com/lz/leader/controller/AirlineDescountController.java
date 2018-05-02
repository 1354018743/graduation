package com.lz.leader.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.leader.service.AirlineDescountService;

import net.sf.json.JSONObject;


@WebServlet("/AirlineDescount/*")
public class AirlineDescountController extends BaseController{
	AirlineDescountService airlineDescountService=new AirlineDescountService();
	//加载所有优惠政策信息
	public void loadDescount (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		int cid=Integer.parseInt(req.getParameter("cid"));
		//分页获取航班信息
		Map<String, Object> descounts=airlineDescountService.loadAllDescount(page,rows,cid);
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(descounts).toString());
	}
	
	//增加优惠政策
	public void addDescount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int fid=Integer.parseInt(req.getParameter("fid"));
		double descount_1 =Double.parseDouble(req.getParameter("descount_1"));
		double descount_2 =Double.parseDouble(req.getParameter("descount_2"));
		boolean result=airlineDescountService.addDescount(fid, descount_1,descount_2);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	
	//修改优惠政策
	public void modifyDescount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int fid=Integer.parseInt(req.getParameter("fid"));
		double descount_1=Double.parseDouble(req.getParameter("descount_1"));
		double descount_2=Double.parseDouble(req.getParameter("descount_2"));
		boolean result=airlineDescountService.modifyDescount(fid,descount_1,descount_2);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}
	
	//根据条件查找折扣信息
	public void searchDescount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		String fid=req.getParameter("fid");
		String starttime =req.getParameter("starttime");
		String endtime=req.getParameter("endtime");
		String cid=req.getParameter("cid");
		String star_airportnumber=req.getParameter("port_name" );
		String end_airportnumber=req.getParameter("end_port_name" );
		String startprice_1=req.getParameter("startprice_1");
		String endprice_1=req.getParameter("endprice_1");
		String startprice_2=req.getParameter("startprice_2");
		String endprice_2=req.getParameter("endprice_2");
		//查找
		Map<String, Object> maps=airlineDescountService.searchDescount(fid,cid,starttime,endtime,star_airportnumber,end_airportnumber,startprice_1,endprice_1,startprice_2,endprice_2,page,rows);
		//返回查找的结果
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(maps).toString());
	}
}
