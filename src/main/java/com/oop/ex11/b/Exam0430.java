package com.oop.ex11.b;

// 각각의 스태틱 멤버를 지정하는 대신 와일드카드(*) 사용가능
// 웬만하면 쓰지 않는게 좋음
import static com.oop.ex11.b.F.m1;
import static com.oop.ex11.b.F.v1;
import static com.oop.ex11.b.sub.M.m2;
import static com.oop.ex11.b.sub.M.v2;

import com.oop.ex11.b.F.X;
import com.oop.ex11.b.sub.M.Y;

class F {
	static int v1;

	static void m1() {
	}

	static class X {
		void test() {
			System.out.println();
		}
	}
}

public class Exam0430 {
	public static void main(String[] args) {
		// 같은 패키지 클래스 스태틱 멤버
		v1 = 100;
		m1();
		X obj = new X();

		// 다른 패키지 클래스 스태틱 멤버
		v2 = 200;
		m2();
		Y obj2 = new Y();
	}
}
