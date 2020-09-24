package com.eomcs.pms.domain;

import java.sql.Date;

import com.eomcs.util.CsvObject;

public class Task implements CsvObject{
	private int no;
	private String content;
	private Date deadline;
	private int status;
	private String owner;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toCsvString() {
		return String.format("%d,%s,%s,%d,%s", 
				this.getNo(),
				this.getContent(),
				this.getDeadline(),
				this.getStatus(),
				this.getOwner());
	}

	public static Task valueOfCsv(String csv) {
		String[] fields = csv.split(",");
		Task task = new Task();
		task.setNo(Integer.parseInt(fields[0]));
		task.setContent(fields[1]);
		task.setDeadline(Date.valueOf(fields[2]));
		task.setStatus(Integer.parseInt(fields[3]));
		task.setOwner(fields[4]);
		return task;
	}

	public Task() {}

	public Task(String csv) {
		String[] fields = csv.split(",");
		this.setNo(Integer.parseInt(fields[0]));
		this.setContent(fields[1]);
		this.setDeadline(Date.valueOf(fields[2]));
		this.setStatus(Integer.parseInt(fields[3]));
		this.setOwner(fields[4]);
	}

}
