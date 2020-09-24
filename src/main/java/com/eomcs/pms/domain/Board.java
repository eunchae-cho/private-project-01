package com.eomcs.pms.domain;

import java.sql.Date;

import com.eomcs.util.CsvObject;

public class Board implements CsvObject {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date registeredDate;
	private int viewCount;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toCsvString() {
		return String.format("%d, %s, %s, %s, %s, %d",
				this.getNo(),
				this.getTitle(),
				this.getContent(),
				this.getWriter(),
				this.getRegisteredDate(),
				this.getViewCount());
	}

	public static Board valueOfCsv(String csv) {
		String[] fields = csv.split(",");
		Board board = new Board();
		board.setNo(Integer.parseInt(fields[0]));
		board.setTitle(fields[1]);
		board.setContent(fields[2]);
		board.setWriter(fields[3]);
		board.setRegisteredDate(Date.valueOf(fields[4]));
		board.setViewCount(Integer.parseInt(fields[5]));
		return board;
	}

	public Board() {}

	public Board(String csv) {
		String[] fields = csv.split(",");
		this.setNo(Integer.parseInt(fields[0]));
		this.setTitle(fields[1]);
		this.setContent(fields[2]);
		this.setWriter(fields[3]);
		this.setRegisteredDate(Date.valueOf(fields[4]));
		this.setViewCount(Integer.parseInt(fields[5]));
	}
}