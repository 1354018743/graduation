package com.lz.common.entity;

public class Student {
	
	private int sid;
	private String name;
	private String stuno;
	private String departure;
	private String grade;
	private String email;
	private int state;
	private int lid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Student(int sid, String name, String stuno, String departure, String grade, String email, int state,
			int lid) {
		super();
		this.sid = sid;
		this.name = name;
		this.stuno = stuno;
		this.departure = departure;
		this.grade = grade;
		this.email = email;
		this.state = state;
		this.lid = lid;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
