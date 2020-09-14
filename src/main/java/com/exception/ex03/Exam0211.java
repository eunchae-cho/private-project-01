package com.exception.ex03;

public class Exam0211 {

	// Error 계열의 예외를 던져서는 안되지만
	// 메서드 선언부에 던지는 예외 표시 선언을 해되 되긴 된다.
	static void m1() throws Error {
		throw new Error();
	}

	// 이렇게 선언할 필요 없다
	static void m2() {
		throw new Error();
	}

	public static void main(String[] args) {

	}

}
