package com.exception.ex01;

public class Exam0120 {
	public static void main(String[] args) {
		int result = Calculator.compute("#", 100, 200);

		if (result == -1) {
			System.out.println("유효하지 않은 연산자입니다.");
		} else {
			System.out.println(result);
		}
	}
}
