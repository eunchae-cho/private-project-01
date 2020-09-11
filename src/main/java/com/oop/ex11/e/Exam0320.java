package com.oop.ex11.e;

public class Exam0320 {

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
		final A obj = new A() {

			@Override
			public void print() {
				System.out.printf("'%s'님 반갑습니다.",name);
			}
		};
		obj.print();
	}
}
