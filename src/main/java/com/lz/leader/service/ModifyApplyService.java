package com.lz.leader.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.lz.leader.dao.ModifyApplyDao;


public class ModifyApplyService {
	public ModifyApplyDao modifyApplyDao =new ModifyApplyDao();
	public boolean accessApply(int aiid){

		return modifyApplyDao.accessApply(aiid);
		
	}
	public boolean modifyApply(int aiid){

		return modifyApplyDao.modifyApply(aiid);
		
	}

}
