package com.oop.ex11.e;

public class Exam0310 {

	static class A {
		String name;

		public A() {
			name = "이름 없음";
		}

		public A(final String name) {
			this.name = name;
		}

		public void print() {
			System.out.println(name);
		}
	}

	public static void main(String[] args) {

		A obj = new A() {};
		obj.print();

		obj = new A("홍길동") {};
		obj.print();

		//obj = new A(100) {}; 파라미터로 int를 설정하지 않았다.
	}

}
