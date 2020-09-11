package com.oop.ex11.c;

import com.oop.ex11.c.D.X;
import com.oop.ex11.c.sub.M;
import com.oop.ex11.c.sub.M.Y;

class D {
	class X {
		void test() {
			System.out.println("X.test()");
		}
	}
}

public class Exam0410 {
	public static void main(String[] args) {
		D outer = new D();
		X obj = outer.new X();
		obj.test();

		M outer2 = new M();
		Y obj2 = outer2.new Y();
		obj2.test();

	}
}
