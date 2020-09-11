package com.oop.ex11.c;

class C {
	static void m1() {
		// static member는 instance member 사용 불가
		//X obj = new X();
		//obj.test();
	}

	void m2() {
		X obj = new X();
		obj.test();

	}

	class X {
		void test() {
			System.out.println("X.test()");
		}
	}
}

public class Exam0310 {
	public static void main(String[] args) {
		C.m1();
		C outer = new C();
		outer.m2();
	}

}
