package com.lz.common.entity;

import java.io.Serializable;

public class Passenger implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int pid;
	private String username;
	private String password;
	private String realname;
	private String cardid;
	private int sex;
	private String tel_number;
	private String email;
	private String fileUIL;
	public String getfileUIL() {
		return fileUIL;
	}
	public void setPicture(String picture) {
		this.fileUIL = picture;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
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
	public Passenger() {
		super();
	}
	public Passenger(String username, String password, String realname, String cardid, int sex, String tel_number,
			String email, String fileUIL) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.cardid = cardid;
		this.sex = sex;
		this.tel_number = tel_number;
		this.email = email;
		this.fileUIL = fileUIL;
	}
	
	

}
