package com.oop.ex12;

public class Exam0210 {

	interface Player {
		void play();
		void stop();
	}

	interface Player2 {
		void play();
	}

	public static void main(String[] args) {

		// 하나의 추상 메서드를 가진 인터페이스만 람다 적용 가능
		//Player p = () -> System.out.println("람다 적용 불가");

		Player2 p = () -> System.out.println("람다 적용 가능");
		p.play();
	}
}
