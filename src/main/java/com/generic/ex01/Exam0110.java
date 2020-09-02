package com.generic.ex01;

// Generic 사용전
public class Exam0110 {

	static class MemberBox {
		Member value;

		public void set(Member value) {
			this.value = value;
		}

		public Member get() {
			return value;
		}
	}

	static class StringBox {
		String value;

		public void set(String value) {
			this.value = value;
		}

		public String get() {
			return value;
		}
	}

	static class IntegerBox {
		Integer value;

		public void set(Integer value) {
			this.value = value;
		}

		public Integer get() {
			return value;
		}
	}

	public static void main(String[] args) {

		MemberBox box1 = new MemberBox();
		box1.set(new Member("홍길동",20));
		Member m = box1.get();
		System.out.println(m);

		StringBox box2 = new StringBox();
		box2.set(new String("Hello"));
		String str = box2.get();
		System.out.println(str);

		IntegerBox box3 = new IntegerBox();
		box3.set(100);
		int i = box3.get();
		System.out.println(i);
	}
}
