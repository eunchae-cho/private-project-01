package com.oop.ex12;

public class Exam0510 {

	static class MyCalculator {
		public static int plus(int a, int b) {return a + b;}
		public static int minus(int a, int b) {return a - b;}
		public static int multiple(int a, int b) {return a * b;}
		public static int divide(int a, int b) {return a / b;}
	}

	static interface Calculator {
		int compute(int a, int b);
	}

	public static void main(String[] args) {
		// 스태틱 메서드를 람다 구현체로 
		// < 조건 >
		// 1. 인터페이스에 한 개의 추상 메서드 존재
		// 2. 인터페이스와 스태틱 메서드의 파라미터 타입과 개수, 리턴 타입이 일치
		// < 문법 >
		// => 클래스명::메서드명

		Calculator c1 = MyCalculator::plus;
		Calculator c2 = MyCalculator::minus;
		Calculator c3 = MyCalculator::multiple;
		Calculator c4 = MyCalculator::divide;

		System.out.println(c1.compute(200, 17));
		System.out.println(c2.compute(200, 17));
		System.out.println(c3.compute(200, 17));
		System.out.println(c4.compute(200, 17));
	}
}
