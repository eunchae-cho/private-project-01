package com.oop.ex12;

public class Exam0310 {

	static interface Player{
		void play();
	}

	static void testPlayer(Player p) {
		p.play();
	}

	public static void main(String[] args) {

		class MyPlayer implements Player {
			@Override
			public void play() {
				System.out.println("실행");
			}
		}

		testPlayer(new MyPlayer());
	}
}
