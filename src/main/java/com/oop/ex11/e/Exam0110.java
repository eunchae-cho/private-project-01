package com.oop.ex11.e;

public class Exam0110 {

	interface A {
		void print();
	}

	public static void main(String[] args) {

		class My implements A {
			@Override
			public void print() {
				System.out.println("Hello");
			}
		}

		A obj = new My();
		obj.print();
	}

}
