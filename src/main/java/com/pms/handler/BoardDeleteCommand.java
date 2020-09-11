package com.pms.handler;

import java.util.List;

import com.pms.domain.Board;
import com.pms.util.Prompt;

public class BoardDeleteCommand implements Command{

	private List<Board> boardList;

	public BoardDeleteCommand(List<Board> list) {
		this.boardList = list;
	}

	@Override
	public void execute() {
		System.out.println("[게시물 삭제]");
		int num = Prompt.inputInt("번호: ");
		int index = indexOf(num);

		if (index == -1) {
			System.out.println("해당 게시물의 번호가 없습니다.");
		}
	}


	private int indexOf(int num) {
		for (int i = 0; i < boardList.size(); i++) {
			Board b = boardList.get(i);
			if(b.getNum() == num) {
				return i;
			}
		}
		return -1;
	}
}
