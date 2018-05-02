package com.lz.student.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.Part;

import com.lz.common.entity.Passenger;
import com.lz.student.dao.Passergereigitdao;

public class Passergerregitservice {
	private Passergereigitdao regitdao=new Passergereigitdao(); 
	
	/*
   * ����ͷ���ȡ�ļ���
   * */
	public String getfilenamebypicture(Part part){
		 //�������ͷ���ַ���
		String contentDisposition = part.getHeader("content-disposition");
		 //������ͷ�л�ȡ�ļ����ƣ�
		String filename = contentDisposition.substring(contentDisposition.indexOf("filename")+10,contentDisposition.length()-1); 
	return filename;
	}
 /*
  * ��ͷ��д��Ӳ���з����ļ�·��
  * */

    public String writeto(Part part){
    	String filename=null;
    	String fileUIL=null;
    	try {
    		//ͷ�����뵽�ڴ�����ȥ
			InputStream input=part.getInputStream();
			//��������ļ�����·��
			filename=romdomfilename();
			fileUIL="airlineTickets/passergerpicture"+"/"+filename;
			//���ڴ�����������ļ�����ȥ
			OutputStream output=new FileOutputStream(fileUIL);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return fileUIL;
    	
    }
    /*
     * ��������ļ���
     * 
     * */
    public String romdomfilename(){
    	 
    	String result = null;//result�����ļ���
    	//�����ļ����漰���������ַ�
    	String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$%";
    	//��������ļ����ĳ���
    	 long t = System.currentTimeMillis();
    	 Random rd = new Random(t);
    	 int filenamelength=rd.nextInt(40)+20;
    	
    	for(int i=0;i<filenamelength;i++){
    		//��������ļ�������str�е��Ǹ��ַ�
       	    long x = System.currentTimeMillis();
       	    Random rd2 = new Random(x);
       	    int index=rd.nextInt(str.length()-1);
       	    //��������ַ�
            char ch=str.charAt(index); 
            //���������ļ���
            result=result+String.valueOf(ch);
    	}
    	
    
    return result;
    	
    }
//�ж��Ƿ�ɹ�
  	
  	public int issuccees(Passenger passenger) {
  		//����ɹ���resultֵ
  		int result=3;
  		if(regitdao.isexitusename(passenger.getUsername())) {
  		//�ж��û��ǲ��Ǵ���
  			result= 1;	
  		}else if(!regitdao.gotodatabase(passenger)){
  		//�ж��Ƿ�д�����ݿ�
  			result=2;
  		}
  		
  		return result;
  	
  	}
}
