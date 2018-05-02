package com.lz.common.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int pre_state;
	private String username;
	private double insurance;
	private Date setouttime;
	private Date achieve;
	private String startAirport;
	private String arriveAirport;
	private String com_name;
	public int getPre_state() {
		return pre_state;
	}
	public void setPre_state(int pre_state) {
		this.pre_state = pre_state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	public Date getSetouttime() {
		return setouttime;
	}
	public void setSetouttime(Date setouttime) {
		this.setouttime = setouttime;
	}
	public Date getAchieve() {
		return achieve;
	}
	public void setAchieve(Date achieve) {
		this.achieve = achieve;
	}
	public String getStartAirport() {
		return startAirport;
	}
	public void setStartAirport(String startAirport) {
		this.startAirport = startAirport;
	}
	public String getArriveAirport() {
		return arriveAirport;
	}
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public Order() {
		super();
	}

	
	 
}
