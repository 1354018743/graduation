package com.lz.leader.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
@WebServlet("/companyLogout/*")
public class CompanyLogoutController extends BaseController{

	public void companylogout (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.setCharacterEncoding("utf-8");
		  resp.setContentType("text/html");
		  PrintWriter out = resp.getWriter();
		  HttpSession session=req.getSession(true);
		  session.invalidate();
		  this.getServletConfig().getServletContext().getRequestDispatcher("/view/AirlineLogin.jsp").forward(req, resp);
		  out.flush();
		  out.close();
	}
	
}
