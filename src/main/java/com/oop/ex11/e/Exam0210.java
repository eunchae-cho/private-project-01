package com.oop.ex11.e;

public class Exam0210 {

	static abstract class A {
		public abstract void print();
	}

	public static void main(String[] args) {

		A obj = new A() {
			@Override
			public void print() {
				System.out.println("hello");
			}
		};

		obj.print();
	}
}


