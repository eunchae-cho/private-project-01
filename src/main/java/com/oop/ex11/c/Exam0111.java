package com.oop.ex11.c;
// inner class

class A2 {
	class X {
		// static member를 가질 수 없음
		//static int v1;
		//static void m1() {}
		//static {}

		int v2;
		void m2() {}
		{}
	}
}

public class Exam0111 {
	public static void main(String[] args) {

		A2 outer = new A2();
		A2.X obj = outer.new X();

		// 간단하게 줄이면
		A2.X obj2 = new A2().new X();
	}
}
