package com.exception.ex04;

public class Exam0110 {
	static void m1() {
		m2();
	}

	static void m2() {
		m3();
	}

	static void m3() {
		m4();
	}

	static void m4() {
		System.out.println("m4() 실행");
	}

	public static void main(String[] args) {
		m1();
	}

}
