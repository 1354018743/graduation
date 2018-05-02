package com.lz.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lz.common.entity.Airport;
import com.lz.manager.dao.AirportDao;

public class AirportService {
	
	AirportDao airportDao=new AirportDao();
	/**
	 * 
	 * �������еĻ���
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
		public Map<String,Object> loadAirport(int pageNum,int pageSize,String port_number,String port_name,String city){
			int total=airportDao.allAirport(port_number,port_name,city).size();
			List<Airport> rows=airportDao.loadAirport(pageNum, pageSize,port_number,port_name,city);
			Map<String,Object> map = new HashMap<>();
			map.put("total",total);
			map.put("rows",rows);
			return map;
			
			
			
		}
		/**
		 * 
		 * ��֤����
		 * 
		 * 
		 */
		public List<Airport> isHaveAirport(String port_number,String port_name,String city){
			
			List<Airport> list = airportDao.allAirport(port_number, port_name, city);
			return list;
			
			
			
		}
		/**
		 * 
		 * 
		 * ��ӻ���
		 * @param port_number
		 * @param port_name
		 * @param city
		 * @return
		 */
		public boolean addAirport( String port_number,String port_name,String city){
			
			return airportDao.addAirport(port_number, port_name, city);
			
		}
		public boolean deleteAirport(String aids){
			  
			String aidStr[]=aids.split(",");
			int[] aid_1=new int[aidStr.length];
			for(int i=0;i<aidStr.length;i++){
				aid_1[i]= Integer.parseInt(aidStr[i]);
				
				
			}
			
			return airportDao.deleteAirport(aid_1);
		}
		public boolean modifyAirport(int aid, String port_number,String port_name,String city){
			
			return airportDao.modifyAirport(aid, port_number, port_name, city);
			
		}
		public Airport loadAirportByAid(int aid){
			
			return airportDao.loadAirportByAid(aid);
			
		}
		public List<Airport> searchAirport(String port_number,String port_name,String city){
			
			return airportDao.searchAirport(port_number, port_name, city);
			
		}
}
