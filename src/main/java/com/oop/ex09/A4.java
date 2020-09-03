package com.oop.ex09;

public interface A4 {
	// 인터페이스는 규칙이기 때문에 인스턴스를 만들 수 없다.
	// new 명령어 사용 불가
	// 인터페이스에 선언되는 모든 변수는
	// public, static 변수, final 상수
	public static final int v1 = 100;
	int v2 = 200;
	static void m1() {};
	// 하지만  static 블록은 불가능
	//static {}
}
