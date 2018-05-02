package com.lz.common.entity;

public class AirCompany {
  private int cid;
  private String inst_number;
  private String com_name;
  private String com_telnumber;
  private int Lid;
public AirCompany() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getInst_number() {
	return inst_number;
}
public void setInst_number(String inst_number) {
	this.inst_number = inst_number;
}
public String getCom_name() {
	return com_name;
}
public AirCompany(int cid, String inst_number, String com_name, String com_telnumber, int lid) {
	super();
	this.cid = cid;
	this.inst_number = inst_number;
	this.com_name = com_name;
	this.com_telnumber = com_telnumber;
	Lid = lid;
}
public void setCom_name(String com_name) {
	this.com_name = com_name;
}
public String getCom_telnumber() {
	return com_telnumber;
}
public void setCom_telnumber(String com_telnumber) {
	this.com_telnumber = com_telnumber;
}
public int getLid() {
	return Lid;
}
public void setLid(int lid) {
	Lid = lid;
}
  
 
}