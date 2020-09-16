package com.oop.ex12;

public class Exam0240 {

	static abstract class Player {
		public abstract void play();
	}

	public static void main(String[] args) {

		// 추상 클래스는 람다 적용이 안된다.
		// 오직 functional interface 즉 추상 메서드를 한 개 가진 인터페이스만!
		// The Target type of expression must be a functional interface
		//Player p = () -> System.out.println("play()");
	}
}
