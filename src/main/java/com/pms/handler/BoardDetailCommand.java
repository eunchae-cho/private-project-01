package com.pms.handler;

import java.util.List;

import com.pms.domain.Board;
import com.pms.util.Prompt;

public class BoardDetailCommand implements Command{

	private List<Board> boardList;

	public BoardDetailCommand(List<Board> list) {
		this.boardList = list;
	}

	@Override
	public void execute() {
		System.out.println("[게시물 상세보기]");
		int num = Prompt.inputInt("번호: ");
		Board b = findByNum(num);

		if (b == null) {
			System.out.println("해당 번호의 게시물이 없습니다.");
			return;
		}

		b.setViewCount(b.getViewCount() + 1);

		System.out.println();
		System.out.printf("번호: %s\n",b.getNum());
		System.out.printf("제목: %s\n",b.getTitel());
		System.out.printf("내용: %s\n",b.getContent());
		System.out.printf("작성자: %s\n",b.getWriter());
		System.out.printf("등록일: %s\n",b.getRegisteredDate());
		System.out.printf("조회수: %s\n",b.getViewCount());
	}

	private Board findByNum(int num) {
		for (int i = 0; i < boardList.size(); i++) {
			Board board = boardList.get(i);
			if (board.getNum() == num) {
				return board;
			}
		}
		return null;
	}
}
