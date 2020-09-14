package com.exception.ex03;

public class Exam0220 {
	// Exception의 Subclass - RuntimeException
	static void m() throws RuntimeException {
		throw new RuntimeException();
	}

	// 스텔스 모드를 지원하기 위한 예외
	static void m2() {
		throw new RuntimeException();
	}

	public static void main(String[] args) {
	}
}
