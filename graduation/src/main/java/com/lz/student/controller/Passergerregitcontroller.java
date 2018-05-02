package com.lz.student.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Passenger;
import com.lz.manager.service.PassengerService;
import com.lz.student.dao.Passergereigitdao;
import com.lz.student.service.Passergerregitservice;


//����ע��
@WebServlet("/passenger2/regit")
@MultipartConfig
public class Passergerregitcontroller extends BaseController{
	Passergerregitservice regitservice=new Passergerregitservice();
	public void rigit(HttpServletRequest req, HttpServletResponse resp){
		//����������������
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		//��ȡע��ҳ��ע���������Ϣ
		String username=req.getParameter("usename");
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		String realname=req.getParameter("realname");
		String sex=req.getParameter("sex");
		String cardid=req.getParameter("cardid");
		String mail=req.getParameter("mail");
		String telephone=req.getParameter("telephone");
	  //��ǰ�˻�ȡͷ��
		Part part=null;
		try {
		   part = req.getPart("file");
		} catch (IOException | ServletException e) {
		   e.printStackTrace();
		}
		//����passergerreigitservice��ȡ�ļ��� 
		String filename=regitservice.getfilenamebypicture(part);
         
		 //����passergerreigitservice��ͷ��д��Ӳ��֮�У�������·��
		 String fileUIL=regitservice.writeto(part);
		//�������󱣴�����
		 Passenger passenger=new Passenger(username,password1, realname, cardid, Integer.parseInt(sex), telephone, mail, fileUIL);
         //�ж�ע���Ƿ�ɹ�
		  int result=regitservice.issuccees(passenger);
		  if(result==3) {
		    	req.setAttribute("loginInfo", "ע��ɹ������¼!");
				try {
					req.getRequestDispatcher("/view/passenger/passengerMain.jsp").forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		  }else if(result==2) {
		    	req.setAttribute("loginInfo", "ע��ʧ�ܣ������쳣,�ֻ��Ż������Ѵ���!");
		    	try {
					req.getRequestDispatcher("/view/passenger/regit.jsp").forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }else if(result==1) {
		    	req.setAttribute("loginInfo", "�û����Ѿ�����!");
		    	try {
					req.getRequestDispatcher("/view/passenger/regit.jsp").forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
          
	}
	
	
	
}
