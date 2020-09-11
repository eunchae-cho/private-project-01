package com.oop.ex11.b;

import com.oop.ex11.b.sub.M;

class D {
	static int v1;

	static void m1() {}

	static class X {
		void test() {
			System.out.println("test()");
		}
	}
}

public class Exam0410 {
	public static void main(String[] args) {
		D.v1 = 100;
		D.m1();
		D.X obj = new D.X();

		M.v2 = 200;
		M.m2();
		M.Y obj2 = new M.Y();
	}

}
