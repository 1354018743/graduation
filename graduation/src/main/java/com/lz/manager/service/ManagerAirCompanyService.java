package com.lz.manager.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.AirCompany;
import com.lz.common.entity.Airport;
import com.lz.manager.dao.ManagerAirCompanyDao;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;
//
public class ManagerAirCompanyService {
   private ManagerAirCompanyDao manageraircompanydao=new ManagerAirCompanyDao();
   
   
   //设置分页数据
   public Map<String,Object> getCompany(int page,int pageSize,String inst_number,String com_name,String com_telnumber){
	  int total=manageraircompanydao.queryAllCompany(inst_number,com_name,com_telnumber).size();
	  List<AirCompany> rows=manageraircompanydao.queryPage(page, pageSize,inst_number,com_name,com_telnumber);
	  
	  Map<String,Object> map=new HashMap<>();
	  map.put("total", total);
	  map.put("rows", rows);
	  return map;
	   
   }
   
   public List<AirCompany> isHaveCompany(String inst_number,String com_name,String com_telnumber){
	  
		List<AirCompany> list = manageraircompanydao.queryAllCompany(inst_number, com_name, com_telnumber);
		
		return list;
		
		
		
	}
  //删除数据
   public boolean deleteCompany(String cids){
	   String cidStr[]=cids.split(",");
		int[] cid_1=new int[cidStr.length];
		for(int i=0;i<cidStr.length;i++){
			cid_1[i]= Integer.parseInt(cidStr[i]);
		}
		return manageraircompanydao.deleteAirCompany(cid_1);
	}
   //修改数据
   public boolean modifyAirCompany(int cid,String inst_number,String com_name,String com_telnumber){
	   return manageraircompanydao.modifyAirCompany(cid,inst_number, com_name, com_telnumber);
   }
    public AirCompany loadAirCompanybycid(int cid){
    	return manageraircompanydao.loadAirCompanybycid(cid);
    }
    //增加
    public boolean addAirCompany(String inst_number,String com_name,String com_telnumber){
    	MessageDigest md5;
    	String password=null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64=new BASE64Encoder();
			password=base64.encode(md5.digest(inst_number.getBytes()));
			
	    	
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return manageraircompanydao.addAirCompany(inst_number,password,com_name, com_telnumber);
    }
   }

