package com.oop.ex12;

public class Exam0130 {

	interface Player {
		void play(String name);
	}

	public static void main(String[] args) {

		Player p1 = (String name) -> System.out.println(name+"님 안녕하세요.");
		p1.play("홍길동");

		Player p2 = (name) -> System.out.println(name+"님 안녕하세요.222");
		p2.play("홍길동");

		Player p3 = name -> System.out.println(name+"님 안녕하세요.333");
		p3.play("홍길동");
	}

}
