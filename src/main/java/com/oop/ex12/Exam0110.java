package com.oop.ex12;

public class Exam0110 {

	interface Player{
		void play();
	}

	public static void main(String[] args) {

		// 익명 클래스
		Player p1 = new Player() {
			@Override
			public void play() {
				System.out.println("익명 클래스");
			}
		};

		p1.play();



		// 람다 
		Player p2 = () -> {
			System.out.println("람다");
		};

		p2.play();
	}
}
