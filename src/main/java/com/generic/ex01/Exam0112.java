package com.generic.ex01;

// Generic 사용전 - 다형적 변수 활용의 문제점
public class Exam0112 {

	static class ObjectBox {
		Object value;

		public void set(Object value) {
			this.value = value;
		}

		public Object get() {
			return value;
		}
	}

	public static void main(String[] args) {

		ObjectBox box1 = new ObjectBox();
		box1.set(new Member("홍길동",20));
		box1.set(new String("hello"));

	}
}
