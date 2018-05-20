package com.lz.leader.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.leader.service.StudentApplyMessageService;

import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/studentApplyMessage/*")
public class StudentApplyMessageController extends BaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//加载所有信息
	public StudentApplyMessageService sms=new StudentApplyMessageService();
	
	public void loadApplyMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		int lid=Integer.parseInt(req.getParameter("lid"));
		String sname=req.getParameter("sname");
		String sno=req.getParameter("sno");

		Map<String,Object> map=sms.loadApplyProgress(page, pageSize,lid,sno,sname);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
		
	}
}
