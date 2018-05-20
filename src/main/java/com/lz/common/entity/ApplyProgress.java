package com.lz.common.entity;

import java.util.Date;

public class ApplyProgress {
	
	private int aiid;
	private int score;
	private int progress;
	private int aid;
	private Date applytime;
	private String sno;
	private String sname;
	public ApplyProgress(int aiid, int score, int progress, int aid, Date applytime, String sno, String sname) {
		super();
		this.aiid = aiid;
		this.score = score;
		this.progress = progress;
		this.aid = aid;
		this.applytime = applytime;
		this.sno = sno;
		this.sname = sname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public ApplyProgress(int aiid, int score, int progress, int aid, Date applytime) {
		super();
		this.aiid = aiid;
		this.score = score;
		this.progress = progress;
		this.aid = aid;
		this.applytime = applytime;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	public int getAiid() {
		return aiid;
	}
	public void setAiid(int aiid) {
		this.aiid = aiid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public ApplyProgress(int aiid, int score, int progress, int aid) {
		super();
		this.aiid = aiid;
		this.score = score;
		this.progress = progress;
		this.aid = aid;
	}
	public ApplyProgress() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
