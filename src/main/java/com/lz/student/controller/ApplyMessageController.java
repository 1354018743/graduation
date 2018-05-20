package com.lz.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.ApplyProgress;
import com.lz.student.service.ApplyMessageService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/applyMessage/*")
public class ApplyMessageController extends BaseController{
	//加载所有机场信息
	public ApplyMessageService applyMessageService=new ApplyMessageService();
	
	public void loadApplyMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		int lid=Integer.parseInt(req.getParameter("lid"));

		Map<String,Object> map=applyMessageService.loadApplyProgress(page, pageSize,lid);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
		
	}
}
