package com.lz.manager.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.manager.service.MStudentApplyMessageService;
import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/managerstudentApplyMessage/*")
public class MStudentApplyMessageController extends BaseController{
	//加载所有机场信息
	public MStudentApplyMessageService sms=new MStudentApplyMessageService();
	
	public void loadApplyMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		String sname=req.getParameter("sname");
		String sno=req.getParameter("sno");
		System.out.println(sname);
		Map<String,Object> map=sms.loadApplyProgress(page, pageSize,sno,sname);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
		
	}
}
