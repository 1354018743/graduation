package com.lz.student.service;

import com.lz.common.entity.Passenger;
import com.lz.student.dao.Passergerlogindao;

public class Passergerloginservice {
	Passergerlogindao logindao=new Passergerlogindao();
	//�����û�����ó˿�
	public Passenger loginuserbyusername(String username) {	
	
		
		return logindao.loginbyusername(username);
	}
   // �ж���֤���Ƿ���ȷ
	public Boolean checkyanzhengma(String yanzhengma,String scyanzhengma){
		if(yanzhengma.equals(scyanzhengma)) {
			return true;	
		}
		
		return false;
	}
	//ͨ�����ݿ���·�����ͷ��
	//public 
}
