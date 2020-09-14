package com.exception.ex04;

public class Exam0120 {
	static void m1(){
		m2();
	}

	static void m2() {
		m3();
	}

	static void m3() {
		m4();
	}

	static void m4() {
		throw new RuntimeException("m4()에서 예외 발생");
	}

	public static void main(String[] args) {
		try {			
			m1();
		} catch (Exception e) {
			System.out.println("e.getMessage()");
		}
	}

}
