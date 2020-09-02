package com.pms.handler;

import com.pms.domain.Board;
import com.pms.util.ArrayList;
import com.pms.util.Prompt;


public class BoardHandler {
	ArrayList<Board> boardList = new ArrayList<>();

	public void add() {
		Board b = new Board();
		System.out.println("[게시물 등록]");
		b.setNum(Prompt.inputInt("번호: "));
		b.setTitel(Prompt.inputString("제목: "));
		b.setContent(Prompt.inputString("내용: "));
		b.setWriter(Prompt.inputString("작성자: "));
		boardList.add(b);
	}	


	public void list() {
		System.out.println("[게시물 목록]");
		for (int i = 0; i < boardList.size(); i++) {
			Board b = boardList.get(i);
			System.out.printf("%d, %s, %s, %s, %s, %d\n",
					b.getNum(),b.getTitel(),b.getContent(),
					b.getWriter(), b.getRegisteredDate(), b.getViewCount());
		}

	}

	public void detail() {
		System.out.println("[게시물 상세보기]");
		int num = Prompt.inputInt("번호: ");
		Board b = findByNum(num);

		if (b == null) {
			System.out.println("해당 번호의 게시물이 없습니다.");
			return;
		}

		b.setViewCount(b.getViewCount() + 1);

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
