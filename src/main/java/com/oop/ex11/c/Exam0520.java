package com.oop.ex11.c;


class F {
	class X{
		// 컴파일러는 모든 생성자에
		// 바깥클래스의 객체 주소를 받는 파라미터를 추가한다.

		//F$X(com.eomcs.oop.ex11.c.F arg0);
		X() {}

		//F$X(com.eomcs.oop.ex11.c.F arg0, int a);
		X(int a) {}

		//F$X(com.eomcs.oop.ex11.c.F arg0, java.lang.String s, int a);
		X(String s, int a) {}
	}
}


public class Exam0520 {
	public static void main(String[] args) {
		F outer = new F();

		// => invokespecial com.eomcs.oop.ex11.c.F$X(com.eomcs.oop.ex11.c.F) [25] 
		// => 예) new X(outer)
		F.X obj = outer.new X();

		// => invokespecial com.eomcs.oop.ex11.c.F$X(com.eomcs.oop.ex11.c.F, int) [25] 
		// => 예) new X(outer, 100)
		F.X obj2 = outer.new X(100);

		// => invokespecial com.eomcs.oop.ex11.c.F$X(com.eomcs.oop.ex11.c.F, java.lang.String, int) [25] 
		// => 예) new X(outer,"kim", 100)
		F.X obj3 = outer.new X("kim",100);
	}
}
