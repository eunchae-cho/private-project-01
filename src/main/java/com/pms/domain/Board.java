package com.pms.domain;

import java.sql.Date;

public class Board {
	private int num;
	private String titel;
	private String content;
	private String writer;
	private Date registeredDate;
	private int viewCount;

	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}


	public String toCsvString() {
		return String.format("%d,%s,%s,%s,%s,%d\n", 
				this.getNum(),
				this.getTitel(),
				this.getContent(),
				this.getWriter(),
				this.getRegisteredDate().toString(),
				this.getViewCount());
	}

	public static Board valueOfCsv(String csv) {
		String[] values = csv.split(",");
		Board board = new Board();
		board.setNum(Integer.parseInt(values[0]));
		board.setTitel(values[1]);
		board.setContent(values[2]);
		board.setWriter(values[3]);
		board.setRegisteredDate(Date.valueOf(values[4]));
		board.setViewCount(Integer.parseInt(values[5]));
		return board;
	}

}
