package com.lz.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.entity.User;


public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		 // 获取request,response,session
		         HttpServletRequest servletRequest = (HttpServletRequest) arg0;
		         HttpServletResponse servletResponse = (HttpServletResponse)arg1;
		         HttpSession session = servletRequest.getSession();
		 
		         String path = servletRequest.getRequestURI();
		         User user = (User) session.getAttribute("user");
//		         String paths[]=path.split("/");
//		         String s=paths[3];
//		         System.out.println(s);
			         if("/graduation/login.jsp".equals(path)) {
			             arg2.doFilter(servletRequest, servletResponse);
			             return;
			         }
			          if (user == null) {
			             // 如果没登录
			             servletResponse.sendRedirect("/graduation/login.jsp");
			         } else {
			            // 登录了
			        	 arg2.doFilter(arg0, arg1);
			         }
		         }
		         
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
