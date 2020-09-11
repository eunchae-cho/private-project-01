package com.oop.ex11.e;

public class Exam0120 {

	interface A {
		void print();
	}

	public static void main(String[] args) {

		// 인터페이스명 레퍼런스 = new 인터페이스명() {}

		A obj = new A() {
			@Override
			public void print() {
				System.out.println("Hello");
			}
		};

		obj.print();

	}
}
