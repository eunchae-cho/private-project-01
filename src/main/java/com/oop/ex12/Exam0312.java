package com.oop.ex12;

public class Exam0312 {

	static interface Player {
		void play();
	}

	static void testPlayer(Player p) {
		p.play();
	}

	public static void main(String[] args) {
		// 좀 더 간단히 표현하기
		testPlayer(new Player() {
			@Override
			public void play() {
				System.out.println("실행");
			}
		});
	}
}
