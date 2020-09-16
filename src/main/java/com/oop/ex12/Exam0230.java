package com.oop.ex12;

public class Exam0230 {

	interface Player {
		static String info() {
			return "Player입니다.";
		}

		default void stop() {}

		void play();
	}

	public static void main(String[] args) {

		Player p = () -> System.out.println("play()");
		p.play();
		System.out.println(Player.info());
	}

}
