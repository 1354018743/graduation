package com.lz.common.entity;

public class User1 {
	
	private int pid;
	private String realname;
	private int sex;
	private String cardid;
	private String tel_number;
	private String email;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTel_number() {
		return tel_number;
	}
	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User1(int pid, String realname, int sex, String cardid, String tel_number, String email) {
		super();
		this.pid = pid;
		this.realname = realname;
		this.sex = sex;
		this.cardid = cardid;
		this.tel_number = tel_number;
		this.email = email;
	}
	public User1() {
		super();
	}
	

}
