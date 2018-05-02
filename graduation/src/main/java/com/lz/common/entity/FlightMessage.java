package com.lz.common.entity;

import java.io.Serializable;
/**
 * 航班信息的实体
 * @author 刘涛
 *
 */
import java.util.Date;
public class FlightMessage implements Serializable{
	
	private int fid;
	private String air_number;
	private Date setouttime;
	private Date achieve;
	private int cid;
	private String port_name;
	private String end_port_name;
	private int state;
	private double price_1;
	private int pricecount_1;
	private String genre_1;
	private double price_2;
	private int pricecount_2;
	private String genre_2;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getAir_number() {
		return air_number;
	}
	public void setAir_number(String air_number) {
		this.air_number = air_number;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPort_name() {
		return port_name;
	}
	public void setPort_name(String port_name) {
		this.port_name = port_name;
	}
	public String getEnd_port_name() {
		return end_port_name;
	}
	public void setEnd_port_name(String end_port_name) {
		this.end_port_name = end_port_name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getPrice_1() {
		return price_1;
	}
	public void setPrice_1(double price_1) {
		this.price_1 = price_1;
	}
	public int getPricecount_1() {
		return pricecount_1;
	}
	public void setPricecount_1(int pricecount_1) {
		this.pricecount_1 = pricecount_1;
	}
	public String getGenre_1() {
		return genre_1;
	}
	public void setGenre_1(String genre_1) {
		this.genre_1 = genre_1;
	}
	public double getPrice_2() {
		return price_2;
	}
	public void setPrice_2(double price_2) {
		this.price_2 = price_2;
	}
	public int getPricecount_2() {
		return pricecount_2;
	}
	public void setPricecount_2(int pricecount_2) {
		this.pricecount_2 = pricecount_2;
	}
	public String getGenre_2() {
		return genre_2;
	}
	public void setGenre_2(String genre_2) {
		this.genre_2 = genre_2;
	}
	public FlightMessage() {
		super();
	}
	
	
	
	
	
	
}
