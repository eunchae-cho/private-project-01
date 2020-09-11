package com.oop.ex11.c;


class H {
	int v1 = 100;
	int v2 = 200;
	int v3 = 300;

	class X {
		int v1 = 10;
		int v2 = 20;

		void m1(int v1) {
			// this를 명시하지 않았을 때 변수를 찾는 순서
			// 1. 로컬 변수
			// 2. 메서드가 소속된 클래스의 인스턴스 필드
			// 3. 바깥 클래스의 인스턴스나 스태틱 필드
			System.out.printf("v1 = %d\n",v1);
			System.out.printf("this.v1 = %d\n",this.v1);
			System.out.printf("H.this.v1 = %d\n",H.this.v1);

			System.out.printf("v2 = %d\n",v2);
			System.out.printf("v3 = %d\n",v3);
		}
	}
}

public class Exam0620 {
	public static void main(String[] args) {
		H outer = new H();
		H.X obj = outer.new X();
		obj.m1(400);
	}
}
