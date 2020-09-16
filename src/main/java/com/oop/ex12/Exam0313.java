package com.oop.ex12;

public class Exam0313 {

	static interface Player {
		void play();
	}

	static void testPlayer(Player p) {
		p.play();
	}

	public static void main(String[] args) {
		// 람다 적용
		testPlayer(() -> System.out.println("실행"));
	}
}
