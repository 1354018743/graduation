package com.lz.leader.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lz.common.controller.BaseController;
import com.lz.common.entity.User;
import com.lz.manager.service.ManagerChangePasswordService;
import com.lz.student.service.ChangePasswordService;

import sun.misc.BASE64Encoder;
@WebServlet(value="/leaderChangePassword/*")
 public class LeaderChangePasswordController extends BaseController {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChangePasswordService cps=new ChangePasswordService();
	 
	 
	 //�޸�����
	public  void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldpassword=req.getParameter("oldpassword");
		
		String passwordagain=req.getParameter("passwordagain");
		HttpSession se=req.getSession();
		User user=(User)se.getAttribute("user");
		int Lid=user.getLid();
		MessageDigest md5;
		String password=null;
		String md5oldpassword=null;
		String md5password=null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			 BASE64Encoder base64en = new BASE64Encoder();
				 password=cps.getPasswordByMD5(Lid);
				 md5oldpassword=base64en.encode(md5.digest(oldpassword.getBytes()));
				 md5password=base64en.encode(md5.digest(passwordagain.getBytes()));
				
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		boolean result;
        if(password.equals(md5oldpassword)){
        	result=cps.updatePassword(Lid, md5password);
        	String s=result+"";
    		resp.getWriter().write(s);	
        }else{
        	result=false;
        	String s=result+"";
        	resp.getWriter().write(s);;
        }
	
	}

	public  void loadApply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	}

}
