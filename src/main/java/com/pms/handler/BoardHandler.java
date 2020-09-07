package com.pms.handler;

import java.sql.Date;

import com.pms.domain.Board;
import com.pms.util.ArrayList;
import com.pms.util.Iterator;
import com.pms.util.List;
import com.pms.util.Prompt;




public class BoardHandler {
	// 1) 다형적 변수의 활용
	// 목록을 다루는 데 필요한 의존 객체를 특정 클래스로 제한하지 말고
	// 상위 클래스의 레퍼런스를 사용하여 여러개의 서브 클래스를 사용할 수 있도록 유연성을 제공
	List<Board> boardList = new ArrayList<>();

	// 2) 의존 객체 주입 활용 
	// - 의존 객체를 이 클래스에서 직접 사용하지 않고 외부로부터 주입받는다.
	// - 생성자의 특성 이용(객체가 작업하는데 필요한 기본 값 또는 의존 객체를 준비하는 메서드)
	public BoardHandler(List<Board> list) {
		this.boardList = list;
	}

	public void add() {
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


	public void list() {
		System.out.println("[게시물 목록]");

		Iterator<Board> iterator = boardList.iterator();

		while (iterator.hasNext()) {
			Board b = iterator.next();
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

		System.out.println();
		System.out.printf("번호: %s\n",b.getNum());
		System.out.printf("제목: %s\n",b.getTitel());
		System.out.printf("내용: %s\n",b.getContent());
		System.out.printf("작성자: %s\n",b.getWriter());
		System.out.printf("등록일: %s\n",b.getRegisteredDate());
		System.out.printf("조회수: %s\n",b.getViewCount());
	}

	public void update() {
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

	public void delete() {
		System.out.println("[게시물 삭제]");
		int num = Prompt.inputInt("번호: ");
		int index = indexOf(num);

		if (index == -1) {
			System.out.println("해당 게시물의 번호가 없습니다.");
		}
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
