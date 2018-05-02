package com.lz.leader.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.leader.service.FlightMessageService;

import net.sf.json.JSONObject;

/**
 * 航班信息相关处理类
 * @author 刘涛
 *
 */

@WebServlet("/flightMessage/*")
public class FlightMessageController extends BaseController{
	
	private FlightMessageService flightMessageService=new FlightMessageService();
	//加载所有的航班信息
	public void loadFlightMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pag=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		int cid=Integer.parseInt(req.getParameter("cid"));
		//分页获取航班信息
		Map<String, Object> flightMessage=flightMessageService.loadFlightMessage(pag,rows,cid);
		//返回分页的航班信息
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(flightMessage).toString());
		
		
	}
	
	//增加航班信息
		public void addFlightMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String air_number=req.getParameter("air_number");
			Date setouttime=null;
			Date achieve=null;
			try {
				setouttime = simpleDateFormat.parse(req.getParameter("setouttime"));
				achieve=simpleDateFormat.parse(req.getParameter("achieve"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int cid=Integer.parseInt(req.getParameter("cid"));
			System.out.println(cid);
			int star_airportnumber=Integer.parseInt(req.getParameter("port_name" ));
			int end_airportnumber=Integer.parseInt(req.getParameter("end_port_name" ));
			double price_1=Double.parseDouble(req.getParameter("price_1"));
			int pricecount_1=Integer.parseInt(req.getParameter("pricecount_1" ));
			String genre_1=req.getParameter("genre_1");
			double price_2=Double.parseDouble(req.getParameter("price_2"));
			int pricecount_2=Integer.parseInt(req.getParameter("pricecount_2"));
			String genre_2=req.getParameter("genre_2");
			//增加
			boolean result=flightMessageService.addFlight(air_number,setouttime,achieve,cid,star_airportnumber,end_airportnumber,price_1,pricecount_1,genre_1,price_2,pricecount_2,genre_2);
			//返回增加的结果
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(result+"");
		}
		//删除航班
		public void deleteFlightMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String fids=req.getParameter("fids");
			//删除
			boolean result=flightMessageService.deleteFlightMessage(fids);
			//返回删除结果
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(result+"");
			
		}
		//修改航班信息
		public void modifyFlightMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String air_number=req.getParameter("air_number");
			Date setouttime=null;
			Date achieve=null;
			try {
				setouttime = simpleDateFormat.parse(req.getParameter("setouttime"));
				achieve=simpleDateFormat.parse(req.getParameter("achieve"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int fid=Integer.parseInt(req.getParameter("fid"));
			double price_1=Double.parseDouble(req.getParameter("price_1"));
			int pricecount_1=Integer.parseInt(req.getParameter("pricecount_1" ));
			double price_2=Double.parseDouble(req.getParameter("price_2"));
			int pricecount_2=Integer.parseInt(req.getParameter("pricecount_2"));
			//修改
			boolean result=flightMessageService.modifyFlightMessage(fid,air_number,setouttime,achieve,price_1,pricecount_1,price_2,pricecount_2);
			//返回修改的结果
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(result+"");
		}
		//根据条件查找航班信息
		public void searchFlightMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int page=Integer.parseInt(req.getParameter("page"));
			int rows=Integer.parseInt(req.getParameter("rows"));
			String air_number=req.getParameter("air_number");
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
			Map<String, Object> maps=flightMessageService.searchFlightMessage(air_number,cid,starttime,endtime,star_airportnumber,end_airportnumber,startprice_1,endprice_1,startprice_2,endprice_2,page,rows);
			//返回查找的结果
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(JSONObject.fromObject(maps).toString());
		}
	
}
