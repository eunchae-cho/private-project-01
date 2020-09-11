package com.oop.ex11.c;

class B {

	static int v1;
	static void m1() {}

	int v2;
	void m2() {}

	class X {
		void test() {
			B.v1 = 100;
			B.m1();

			v1 = 200;
			m1();

			v2 = 100;
			m2();
		}
	}
}

public class Exam0210 {
	public static void main(String[] args) {
		B outer = new B();

		B.X obj = outer.new X();
		obj.test();

		System.out.println(B.v1);
		System.out.println(outer.v2);
	}
}
