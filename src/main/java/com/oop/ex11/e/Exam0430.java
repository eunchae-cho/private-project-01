package com.oop.ex11.e;

public class Exam0430 {

	interface A {
		void print();
	}

	void m1() {
		A obj = new A() {
			@Override
			public void print() {
				System.out.println("hello");
			}
		};

		obj.print();
	}

	public static void main(String[] args) {
		Exam0430 r = new Exam0430();
		r.m1();
	}

}
