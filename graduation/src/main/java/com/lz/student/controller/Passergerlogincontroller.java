package com.lz.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Passenger;
import com.lz.student.service.Passergerloginservice;

@WebServlet("/passenger2/login")
public class Passergerlogincontroller extends BaseController{
	Passergerloginservice loginservice=new Passergerloginservice();
	   public void login(HttpServletRequest req, HttpServletResponse resp) {
		//�ӵ�¼ҳ���ȡ�û���������
		  String username=req.getParameter("username");
		  String password=req.getParameter("password");
		  String yanzhengma=req.getParameter("yanzhengma");
		//����session��ȡǰ��������ɵ���֤��
		  String scyanzhengma=req.getParameter("scyanzhengma");
	      System.out.println(username+"/"+password+"/"+yanzhengma+"/");
	      System.out.println(scyanzhengma);
		  //��passergerservice��ȥ�ж�username �� password
		  Passenger passenger=loginservice.loginuserbyusername(username);
		//��passergerservice��ȥ�ж�ǰ�˴�������֤���������Ƿ���ȷ
		  Boolean result=loginservice.checkyanzhengma(yanzhengma, scyanzhengma);
		  
	    
		  if(passenger!=null & result) {
			   //��ն����д��������
			  passenger.setPassword(null);
			  //����ǰ�û�������session������
			  HttpSession session = req.getSession();
			  session.setAttribute("passenger", passenger);
			  //��ת��������
			  try {
				req.getRequestDispatcher("/view/passenger/passengerMain.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			  //��ȡͷ����������
			  
		  }else if(passenger == null) {
		  //���ʧ����ת����½���沢��ʾ��¼ʧ��
			  req.setAttribute("loginInfo", "�û������������");
			  try {
				req.getRequestDispatcher("/view/passenger/login.jsp").forward(req, resp);
			   } catch (ServletException | IOException e) {
				
				e.printStackTrace();
			   }
	      }else if(!result) {
	    	  req.setAttribute("loginInfo", "��֤���������");
	    	  try {
					req.getRequestDispatcher("/view/passenger/login.jsp").forward(req, resp);
				   } catch (ServletException | IOException e) {
					
					e.printStackTrace();
				   }
	      }
	
	    }  	
	
	
	   }
