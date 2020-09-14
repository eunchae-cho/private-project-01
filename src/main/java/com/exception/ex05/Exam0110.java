package com.exception.ex05;

import java.sql.Date;
import java.util.Scanner;

public class Exam0110 {

	static Board read() {
		try (Scanner keyScan = new Scanner(System.in)){
			Board board = new Board();

			System.out.print("번호> ");
			board.setNo(Integer.parseInt(keyScan.nextLine()));

			System.out.print("제목> ");
			board.setTitle(keyScan.nextLine());

			System.out.print("내용> ");
			board.setContent(keyScan.nextLine());

			System.out.print("등록일> ");
			board.setCreatedDate(Date.valueOf(keyScan.nextLine()));

			return board;
		}
	}

	public static void main(String[] args) {
		Board board = read();
		System.out.println("-----------------");
		System.out.printf("번호: %\n", board.getNo());
		System.out.printf("제목: %\n", board.getTitle());
		System.out.printf("내용: %\n", board.getContent());
		System.out.printf("등록일: %\n", board.getCreatedDate());
	}
}
