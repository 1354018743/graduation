package com.lz.common.entity;

public class Airport {
	private int aid;
	private String port_number;
	private String port_name;
	private String city;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getPort_number() {
		return port_number;
	}
	public void setPort_number(String port_number) {
		this.port_number = port_number;
	}
	public String getPort_name() {
		return port_name;
	}
	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Airport() {
		super();
	}
	public Airport(int aid, String port_number, String port_name, String city) {
		super();
		this.aid = aid;
		this.port_number = port_number;
		this.port_name = port_name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Airport [aid=" + aid + ", port_number=" + port_number + ", port_name=" + port_name + ", city=" + city
				+ "]";
	}
	

}
