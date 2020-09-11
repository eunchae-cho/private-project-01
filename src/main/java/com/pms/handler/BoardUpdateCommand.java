package com.pms.handler;

import java.util.List;

import com.pms.domain.Board;
import com.pms.util.Prompt;

public class BoardUpdateCommand implements Command{

	private List<Board> boardList;

	public BoardUpdateCommand(List<Board> list) {
		this.boardList = list;
	}

	@Override
	public void execute() {
		System.out.println("[게시물 변경]");
		int num = Prompt.inputInt("번호: ");
		Board b = findByNum(num);

		if (b == null) {
			System.out.println("해당 번호의 게시물이 없습니다.");
			return;
		}

		System.out.println("번호: "+num);
		String titel = Prompt.inputString("제목: "+b.getTitel());
		String content = Prompt.inputString(b.getContent());
		String writer = Prompt.inputString(b.getWriter());
		String reponse = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
		if (!reponse.equalsIgnoreCase("y")) {
			System.out.println("게시글 변경을 취소했습니다.");
			return;
		} 

		b.setTitel(titel);
		b.setContent(content);
		b.setWriter(writer);
		System.out.println("게시물을 변경하였습니다.");
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
