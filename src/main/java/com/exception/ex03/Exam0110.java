package com.exception.ex03;

public class Exam0110 {
	static void m() {
		//예외를 호출자에게 알려주는 문법
		// throw [Throwable 객체];
		// throw new String()은 안됨
		throw new RuntimeException("예외가 발생했습니다.");
	}

	public static void main(String[] args) {

		try {
			m();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("시스템을 종료합니다.");
	}
}
