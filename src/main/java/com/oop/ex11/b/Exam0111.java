package com.oop.ex11.b;


class A2 {
	static class X {
		static int v1;
		static void m1() {}
		static {}

		int v2;
		void m2() {}
		{}
	}
}


public class Exam0111 {
	public static void main(String[] args) {
		A2.X obj;
		obj = new A2.X();
	}
}
