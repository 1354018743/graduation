package com.lz.common.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Ticketsxs {
	private int cid;
	private String com_name;
	private Timestamp setouttime;
	private Timestamp achieve;
	private int star_airportnumber;
	private String starport_name;
	private int end_airportnumber;
	private String endport_name;
	private Double price_2;
	private Double price_1;
	private long pricecount_2;
	private long pricecount_1;
	private int total;
	
	public Ticketsxs(int cid, String com_name, Timestamp setouttime, Timestamp achieve, int star_airportnumber,
			String starport_name, int end_airportnumber, String endport_name, Double price_2, Double price_1,
			long pricecount_2, long pricecount_1, int total) {
		super();
		this.cid = cid;
		this.com_name = com_name;
		this.setouttime = setouttime;
		this.achieve = achieve;
		this.star_airportnumber = star_airportnumber;
		this.starport_name = starport_name;
		this.end_airportnumber = end_airportnumber;
		this.endport_name = endport_name;
		this.price_2 = price_2;
		this.price_1 = price_1;
		this.pricecount_2 = pricecount_2;
		this.pricecount_1 = pricecount_1;
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public Timestamp getSetouttime() {
		return setouttime;
	}
	public void setSetouttime(Timestamp setouttime) {
		this.setouttime = setouttime;
	}
	public Timestamp getAchieve() {
		return achieve;
	}
	public void setAchieve(Timestamp achieve) {
		this.achieve = achieve;
	}
	public int getStar_airportnumber() {
		return star_airportnumber;
	}
	public void setStar_airportnumber(int star_airportnumber) {
		this.star_airportnumber = star_airportnumber;
	}
	public String getStarport_name() {
		return starport_name;
	}
	public void setStarport_name(String starport_name) {
		this.starport_name = starport_name;
	}
	public int getEnd_airportnumber() {
		return end_airportnumber;
	}
	public void setEnd_airportnumber(int end_airportnumber) {
		this.end_airportnumber = end_airportnumber;
	}
	public String getEndport_name() {
		return endport_name;
	}
	public void setEndport_name(String endport_name) {
		this.endport_name = endport_name;
	}
	public Double getPrice_2() {
		return price_2;
	}
	public void setPrice_2(Double price_2) {
		this.price_2 = price_2;
	}
	public Double getPrice_1() {
		return price_1;
	}
	public void setPrice_1(Double price_1) {
		this.price_1 = price_1;
	}
	public long getPricecount_2() {
		return pricecount_2;
	}
	public void setPricecount_2(long pricecount_2) {
		this.pricecount_2 = pricecount_2;
	}
	public long getPricecount_1() {
		return pricecount_1;
	}
	public void setPricecount_1(long pricecount_1) {
		this.pricecount_1 = pricecount_1;
	}
	public Ticketsxs() {
		super();
	}
	
	
}
