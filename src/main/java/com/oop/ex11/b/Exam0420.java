package com.oop.ex11.b;

import static com.oop.ex11.b.E.m1;
import static com.oop.ex11.b.E.v1;
import static com.oop.ex11.b.sub.M.m2;
import static com.oop.ex11.b.sub.M.v2;

// 중첩 클래스를 import할 때는 static을 적지 않는다.
import com.oop.ex11.b.E.X;
import com.oop.ex11.b.sub.M.Y;


class E {
	static int v1;

	static void m1() {}

	static class X {
		void test() {
			System.out.println("test()");
		}
	}
}

public class Exam0420 {
	public static void main(String[] args) {
		// 같은 패키지 클래스 멤버
		v1 = 100;
		m1();
		X obj = new X();

		// 다른 패키지 클래스 멤버
		v2 = 200;
		m2();
		Y obj2 = new Y();
	}

}
