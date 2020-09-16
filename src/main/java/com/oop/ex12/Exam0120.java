package com.oop.ex12;

public class Exam0120 {

	interface Player {
		void play();
	}

	public static void main(String[] args) {

		Player p1 = () -> {
			System.out.println("테스트 1");
		};
		p1.play();


		// 중괄호 생략 가능
		Player p2 = () -> System.out.println("테스트스 2");
		p2.play();

		//하지만 괄호 생략 불가 
	}
}
