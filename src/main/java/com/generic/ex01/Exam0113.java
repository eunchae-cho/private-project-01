package com.generic.ex01;

// Generic 사용후 - 다형적 변수의 한계 극복
public class Exam0113 {

	static class Box<T> {
		T value;

		public void set(T value) {
			this.value = value;
		}

		public T get() {
			return value;
		}
	}

	public static void main(String[] args) {
		Box<Member> box1;
		box1 = new Box<Member>();
		box1 = new Box<>();
		//box1 = new Box();
		//<> 생략시 경고 - new Box<Object>()로 됨

		box1.set(new Member("홍길동",20));
		Member m = box1.get();
		System.out.println(m);

	}

}
