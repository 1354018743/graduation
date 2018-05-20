package com.lz.common.entity;

public class Apply {
	
	private int aid;
	private String name;
	private String studentno;
	private int lid;
	private int population;
	private String country;
	private String allowances;
	private String ranking;
	private String principle;
	private String subsidize;
	private String spending;
	private String work;
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apply(int aid, String name, String studentno, int lid, int population, String country, String allowances,
			String ranking, String principle, String subsidize, String spending, String work) {
		super();
		this.aid = aid;
		this.name = name;
		this.studentno = studentno;
		this.lid = lid;
		this.population = population;
		this.country = country;
		this.allowances = allowances;
		this.ranking = ranking;
		this.principle = principle;
		this.subsidize = subsidize;
		this.spending = spending;
		this.work = work;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentno() {
		return studentno;
	}
	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAllowances() {
		return allowances;
	}
	public void setAllowances(String allowances) {
		this.allowances = allowances;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getPrinciple() {
		return principle;
	}
	public void setPrinciple(String principle) {
		this.principle = principle;
	}
	public String getSubsidize() {
		return subsidize;
	}
	public void setSubsidize(String subsidize) {
		this.subsidize = subsidize;
	}
	public String getSpending() {
		return spending;
	}
	public void setSpending(String spending) {
		this.spending = spending;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}

}
