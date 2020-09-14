package com.exception.ex01;

public class Exam0130 {

	public static void main(String[] args) {
		int result = Calculator2.compute("#", 100, 200);

		if (result == -1212121212) {
			System.out.println("유효하지 않은 연산자입니다.");
		} else {
			System.out.println(result);
		}

		result = Calculator2.compute("-", 6, 7);
		if (result == -1212121212) {
			System.out.println("유효하지 않은 연산자입니다.");
		} else {
			System.out.println(result);
		}
	}

}
