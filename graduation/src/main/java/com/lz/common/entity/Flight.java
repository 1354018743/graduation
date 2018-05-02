package com.lz.common.entity;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable{

	private static final long serialVersionUID = 1L;
	private String com_name;
	private Date setouttime;
	private Date achieve;
	private String startAirport;
	private String arriveAirport;
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
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
	public Flight() {
		super();
	}
	
}
