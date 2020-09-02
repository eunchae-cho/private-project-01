package com.generic.ex01;

import java.util.ArrayList;

public class Exam0223 {

	static class A {}
	static class B1 extends A {}
	static class B2 extends A {}
	static class C extends B1 {}

	static void m1(ArrayList<B1> list) {
		//list.add(new Object());
		//list.add(new A());
		list.add(new B1());
		///list.add(new B2());
		list.add(new C());

		// ArrayList<B1>이 아니면 에러발생
		for (int i = 0; i < list.size(); i++) {
			B1 temp = list.get(i);
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		//m1(ArrayList<B1>);

		ArrayList list = new ArrayList();
		list.add(new B1());
		list.add(new String());
		list.add(new java.util.Date());
		list.add(new StringBuffer());

		m1(list);

		m1( new ArrayList()); // 안 쓰는게 좋음
		//m1(new ArrayList<Object>());
		//m1(new ArrayList<A>());
		m1(new ArrayList<B1>());
		//m1(new ArrayList<B2>());
		//m1(new ArrayList<C>());

	}
}
