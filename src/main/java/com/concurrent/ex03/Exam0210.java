package com.concurrent.ex03;

public class Exam0210 {
	public static void main(String[] args) {

		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("==> " + i);
			}
		}).start();


		for (int i = 0; i < 1000; i++) {
			System.out.println(">>> " + i);
		}
	}
}
