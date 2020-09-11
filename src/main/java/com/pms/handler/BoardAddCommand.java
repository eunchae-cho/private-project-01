package com.pms.handler;

import java.sql.Date;
import java.util.List;

import com.pms.domain.Board;
import com.pms.util.Prompt;

public class BoardAddCommand implements Command {

	private List<Board> boardList;

	public BoardAddCommand(List<Board> list) {
		this.boardList = list;
	}
	@Override
	public void execute() {
		Board b = new Board();
		System.out.println("[게시물 등록]");
		b.setNum(Prompt.inputInt("번호: "));
		b.setTitel(Prompt.inputString("제목: "));
		b.setContent(Prompt.inputString("내용: "));
		b.setWriter(Prompt.inputString("작성자: "));
		b.setRegisteredDate(new Date(System.currentTimeMillis()));
		b.setViewCount(0);
		boardList.add(b);
		System.out.println("게시물이 등록되었습니다.");
	}
}
