package com.lz.common.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 优惠政策实体类
 * @author ASUS
 *
 */
public class Descount implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int did;
	private double descount_1;
	private double descount_2;
	private int fid;
	private Date setouttime;
	private Date achieve;
	private int cid;
	private String port_name;
	private String end_port_name;
	private int state;
	private double price_1;
	private String genre_1;
	private double price_2;
	private String genre_2;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public double getDescount_1() {
		return descount_1;
	}
	public void setDescount_1(double descount_1) {
		this.descount_1 = descount_1;
	}
	public double getDescount_2() {
		return descount_2;
	}
	public void setDescount_2(double descount_2) {
		this.descount_2 = descount_2;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
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
	public String getGenre_2() {
		return genre_2;
	}
	public void setGenre_2(String genre_2) {
		this.genre_2 = genre_2;
	}
	public Descount() {
		super();
	}
	
	
	
	
}
