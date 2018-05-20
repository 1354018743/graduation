package com.lz.leader.service;

import com.lz.common.entity.Leader;
import com.lz.leader.dao.LeaderMessageDao;
//审核人员信息
public class LeaderMessageService {
	public LeaderMessageDao lmd=new LeaderMessageDao();
	//根据登录号加载审核人员信息
	public Leader loadLeaderMessageByLid(int lid) {
		return lmd.loadLeaderMessageByLid(lid);
	}
	//修改审核人员信息
	public boolean modifyLeaderMessage(int leaderid,String name,String leaderno,String job,String departure,String workplace,String phone) {
		return lmd.modifyLeaderMessage(leaderid,name,leaderno,job,departure,workplace,phone);
	}

}
