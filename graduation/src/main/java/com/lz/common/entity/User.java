package com.lz.common.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Lid;
	private String username;
	private String password;
	private String statem;
	private int usertype;
	public int getLid() {
		return Lid;
	}
	public void setLid(int lid) {
		Lid = lid;
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
	public String getStatem() {
		return statem;
	}
	public void setStatem(String statem) {
		this.statem = statem;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public User() {
		super();
	}
	public User(int lid, String username, String password, String statem, int usertype) {
		super();
		Lid = lid;
		this.username = username;
		this.password = password;
		this.statem = statem;
		this.usertype = usertype;
	}
	
	
	

}
