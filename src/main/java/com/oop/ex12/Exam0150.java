package com.oop.ex12;

public class Exam0150 {
	interface Calculator {
		int compute(int a, int b);
	}

	public static void main(String[] args) {

		Calculator c1 = (a, b) -> {
			return a + b;
		};
		System.out.println(c1.compute(1, 2));


		// 중괄호{}와 return 키워드 같이 생략해야 함
		Calculator c2 = (a, b) -> a - b;
		System.out.println(c2.compute(5, 3));

	}
}
