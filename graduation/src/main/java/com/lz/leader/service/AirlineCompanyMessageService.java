package com.lz.leader.service;

import com.lz.common.entity.AirCompany;
import com.lz.leader.dao.AirlinCompanyMessageDao;
//航空公司信息服务类
public class AirlineCompanyMessageService {
	AirlinCompanyMessageDao airlinCompanyMessageDao=new AirlinCompanyMessageDao();
	
	//根据登录号加载航空公司信息
	public AirCompany loadCompanyMessageByLid(int lid) {
		return airlinCompanyMessageDao.loadCompanyMessageByLid(lid);
	}
	//修改航空公司信息
	public boolean modifyCompanyMessage(String inst_number,String com_name,String com_telnumber) {
		return airlinCompanyMessageDao.modifyCompanyMessage(inst_number,com_name,com_telnumber);
	}

}
