package com.lz.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lz.commn.uitl.DBUtil;
import com.lz.common.controller.BaseController;
import com.lz.common.entity.FlightMessage;
import com.lz.student.dao.Ticketdao;
import com.lz.student.service.Ticketservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet("/tickets/*")
public class Ticketcontroller extends BaseController {
	private static final Long serialVersionUID=1L;
	private Ticketservice ticketservice=new Ticketservice();
	
	public void loadAllTicketspag(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		String startplace = req.getParameter("startplace");
		System.out.println(startplace);
		String endplace = req.getParameter("endplace");
		String danchengtime = req.getParameter("danchengtime");
		String wanfantime = req.getParameter("wanfantime");
		Map<String,Object> map=ticketservice.loadTicketPage( page, rows,startplace,endplace,danchengtime,wanfantime);
		req.setCharacterEncoding("utf-8");
		
		resp.getWriter().write(JSONArray.fromObject(map).toString());
		
		System.out.println(startplace);
	}
      /*加载所有的票信息*/
	  public void loadAllTickets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		
		JSONObject json=ticketservice.loadAllTickts( page, rows);
		req.setCharacterEncoding("utf-8");
		System.out.println(JSONArray.fromObject(json).toString());
		resp.getWriter().write(JSONArray.fromObject(json).toString());
	 }

}
