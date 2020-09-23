package com.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	private int num;
	private String content;
	private Date deadline;
	private int status;
	private String manager;


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

	public String toCsvString() {
		return String.format("%d,%s,%s,%d,%s\n", 
				this.getNum(),
				this.getContent(),
				this.getDeadline().toString(),
				this.getStatus(),
				this.getManager());
	}

	public static Task valueOfCsv(String csv) {
		String[] values = csv.split(",");
		Task task = new Task();
		task.setNum(Integer.parseInt(values[0]));
		task.setContent(values[1]);
		task.setDeadline(Date.valueOf(values[2]));
		task.setStatus(Integer.parseInt(values[3]));
		task.setManager(values[4]);
		return task;
	}


}
