package com.concurrent.ex01;

public class Exam0110 {
	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			System.out.println("==> " + i);
		}

		for (int i = 0; i < 1000; i++) {
			System.out.println(">>> " + i);
		}
	}
}
