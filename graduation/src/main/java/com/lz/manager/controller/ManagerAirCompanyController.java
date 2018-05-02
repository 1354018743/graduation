package com.lz.manager.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.AirCompany;
import com.lz.manager.service.ManagerAirCompanyService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet(value="/managercompany/*")
public class ManagerAirCompanyController extends BaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ManagerAirCompanyService macs=new ManagerAirCompanyService();
		//删除公司
	public void deleteCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cids=req.getParameter("cids");
		
		boolean result;
		result=macs.deleteCompany(cids);
		String s=result+"";
		resp.getWriter().write(s);	

	}

			
			
	//获取page，rows传值		
	public void loadCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=Integer.parseInt(req.getParameter("page"));
		int pageSize=Integer.parseInt(req.getParameter("rows"));
		String inst_number=req.getParameter("inst_number1");
		String com_name=req.getParameter("com_name1");
		String com_telnumber=req.getParameter("com_telnumber1");
		
		System.out.println(inst_number);
		Map<String,Object> map=macs.getCompany(page, pageSize,inst_number,com_name,com_telnumber);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONObject.fromObject(map).toString());
		
	}




	public void modifyCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inst_number=req.getParameter("inst_number");
		String com_name=req.getParameter("com_name");
		String com_telnumber=req.getParameter("com_telnumber");
		int cid=Integer.parseInt(req.getParameter("cid"));
		boolean result;
		result=macs.modifyAirCompany(cid,inst_number, com_name, com_telnumber);
		
		String s=result+"";
		resp.getWriter().write(s);
		
	}
   public void loadCompanyByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   int cid=Integer.parseInt(req.getParameter("cid"));
	   System.out.println(cid);
	   boolean result;
	   AirCompany aircompany=macs.loadAirCompanybycid(cid);
	   resp.setCharacterEncoding("utf-8");
	   resp.getWriter().write(JSONArray.fromObject(aircompany).toString());
   }

   public void isHaveCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inst_number=req.getParameter("inst_number");
		String com_name=req.getParameter("com_name");
		String com_telnumber=req.getParameter("com_telnumber");
		
	
		List<AirCompany> list =macs.isHaveCompany(inst_number,com_name,com_telnumber);
		AirCompany A=list.get(0);
		 String num=A.getInst_number();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(num);
		
	} 


//增加
   public void addCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String inst_number=req.getParameter("inst_number");
	   System.out.println(inst_number);
		String com_name=req.getParameter("com_name");
		String com_telnumber=req.getParameter("com_telnumber");
		boolean result;
		result=macs.addAirCompany(inst_number, com_name, com_telnumber);
		String s=result+"";
		resp.getWriter().write(s);
}
}
