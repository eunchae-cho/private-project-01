package com.oop.ex11.c;

class A {
	class X {

	}
}

public class Exam0110 {
	public static void main(String[] args) {
		A.X obj;

		// 인스턴스 생성 - 컴파일 오류
		//obj = new A.X();

		// 바깥 클래스의 인스턴스를 준비하고 
		// 그 인스턴스 주소를 사용하여  inner class의 인스턴스 생성
		A outer = null;
		obj = outer.new X();
	}
}
