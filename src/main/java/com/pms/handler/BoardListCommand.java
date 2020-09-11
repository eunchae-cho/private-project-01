package com.pms.handler;

import java.util.Iterator;
import java.util.List;

import com.pms.domain.Board;


public class BoardListCommand implements Command{

	private List<Board> boardList;

	public BoardListCommand(List<Board> list) {
		this.boardList = list;
	}

	@Override
	public void execute() {
		System.out.println("[게시물 목록]");

		Iterator<Board> iterator = boardList.iterator();

		while (iterator.hasNext()) {
			Board b = iterator.next();
			System.out.printf("%d, %s, %s, %s, %s, %d\n",
					b.getNum(),b.getTitel(),b.getContent(),
					b.getWriter(), b.getRegisteredDate(), b.getViewCount());
		}
	}
}
