package com.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	private int num;
	private String titel;
	private String content;
	private Date start;
	private Date end;
	private String owner;
	private String members;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}

	public String toCsvString() {
		return String.format("%d,%s,%s,%s,%s,%s,%s\n", 
				this.getNum(),
				this.getTitel(),
				this.getContent(),
				this.getStart().toString(),
				this.getEnd().toString(),
				this.getOwner(),
				this.getMembers());
	}

	public static Project valueOfCsv(String csv) {
		String[] values = csv.split(",");
		Project project = new Project();
		project.setNum(Integer.parseInt(values[0]));
		project.setTitel(values[1]);
		project.setContent(values[2]);
		project.setStart(Date.valueOf(values[3]));
		project.setEnd(Date.valueOf(values[4]));
		project.setOwner(values[5]);
		project.setMembers(values[6]);
		return project;
	}

}
