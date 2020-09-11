package com.oop.ex11.e;

public class Exam0420 {

	interface A {
		void print();
	}

	A obj = new A() {
		@Override
		public void print() {
			System.out.println("hello");
		}
	};

}
