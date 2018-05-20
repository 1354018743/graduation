package com.lz.student.service;

import java.text.ParseException;

import com.lz.student.dao.ApplyUploadDao;

public class ApplyUploadService {
	public ApplyUploadDao aud=new ApplyUploadDao();
	public boolean addApply(String studentno,String name,int lid,int population,String contry,String allowances,String ranking,String principle,String subsidize,String spending, String work) throws ParseException{
		
		
		return aud.addApply(studentno,name,lid,population, contry, allowances, ranking, principle, subsidize, spending, work);
	}

}
