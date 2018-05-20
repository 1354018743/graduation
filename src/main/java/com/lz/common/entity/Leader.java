package com.lz.common.entity;

public class Leader {
		private int leaderid;
		private String leaderno;
		private String name;
		private String job;
		private String departure;
		private String workplace;
		private String phone;
		private int rank;
		private int lid;
		public int getLeaderid() {
			return leaderid;
		}
		public void setLeaderid(int leaderid) {
			this.leaderid = leaderid;
		}
		public String getLeaderno() {
			return leaderno;
		}
		public void setLeaderno(String leaderno) {
			this.leaderno = leaderno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getDeparture() {
			return departure;
		}
		public void setDeparture(String departure) {
			this.departure = departure;
		}
		public String getWorkplace() {
			return workplace;
		}
		public void setWorkplace(String workplace) {
			this.workplace = workplace;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public int getLid() {
			return lid;
		}
		public void setLid(int lid) {
			this.lid = lid;
		}
		public Leader(int leaderid, String leaderno, String name, String job, String departure, String workplace,
				String phone, int rank, int lid) {
			super();
			this.leaderid = leaderid;
			this.leaderno = leaderno;
			this.name = name;
			this.job = job;
			this.departure = departure;
			this.workplace = workplace;
			this.phone = phone;
			this.rank = rank;
			this.lid = lid;
		}
		public Leader() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
