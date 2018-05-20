package com.lz.common.entity;

public class Reg {
	public int regid;
	public Reg(int regid, String studentno, String name, String email, String departrue, String grade) {
		super();
		this.regid = regid;
		this.studentno = studentno;
		this.name = name;
		this.email = email;
		this.departrue = departrue;
		this.grade = grade;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public String studentno;
	public String name;
	public String email;
	public String departrue;
	public Reg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reg(String departrue) {
		super();
		this.departrue = departrue;
	}
	public String getStudentno() {
		return studentno;
	}
	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartrue() {
		return departrue;
	}
	public void setDepartrue(String departrue) {
		this.departrue = departrue;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String grade;

}
