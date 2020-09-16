package com.oop.ex12;

public class Exam0140 {
	interface Player {
		void play(String name, int age);
	}

	public static void main(String[] args) {

		Player p1 = (String name, int age) -> System.out.printf("%s(%d세)님 환영합니다.\n",name,age);
		p1.play("홍길동", 20);

		Player p2 = (name, age) -> System.out.printf("%s(%d세)님 환영합니다.\n",name,age);
		p2.play("홍길동", 30);

		// 파라미터가 여러 개일 때는 괄호를 생략하여 쓸 수 없다. 
	}
}
