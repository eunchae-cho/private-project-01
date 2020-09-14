package com.exception.ex01;

public class Exam0131 {

	public static void main(String[] args) {
		int result = Calculator2.compute("+", -2078654356, 866533144);
		if (result == -1212121212) {
			System.out.println("유효하지 않은 연산자입니다.");
		} else {
			System.out.println(result);
		}
	}
}
