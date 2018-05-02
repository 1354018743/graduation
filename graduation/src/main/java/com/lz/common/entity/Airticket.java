package com.lz.common.entity;

import java.io.Serializable;

public class Airticket implements Serializable {
  private static final long serialVersionUID = 1L;
	
   private int tid;
   private double price_1;
   private long pricecount_1;
   private String genre_1;
   private double price_2;
   private long pricecount_2;
   private String genre_2;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public double getPrice_1() {
	return price_1;
}
public void setPrice_1(double price_1) {
	this.price_1 = price_1;
}
public long getPricecount_1() {
	return pricecount_1;
}
public void setPricecount_1(long pricecount_1) {
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
public long getPricecount_2() {
	return pricecount_2;
}
public void setPricecount_2(long pricecount_2) {
	this.pricecount_2 = pricecount_2;
}
public String getGenre_2() {
	return genre_2;
}
public void setGenre_2(String genre_2) {
	this.genre_2 = genre_2;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Airticket() {
	super();
}
public Airticket(double price_1, long pricecount_1, String genre_1, double price_2, long pricecount_2, String genre_2) {
	super();
	this.price_1 = price_1;
	this.pricecount_1 = pricecount_1;
	this.genre_1 = genre_1;
	this.price_2 = price_2;
	this.pricecount_2 = pricecount_2;
	this.genre_2 = genre_2;
}
   
   
}
