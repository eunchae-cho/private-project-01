package com.generic.ex01;

import java.util.ArrayList;

public class Exam0222 {
	static class A {}
	static class B1 extends A {}
	static class B2 extends A {}
	static class C extends B1 {}

	static void m1(ArrayList<?> list) {
		//		list.add(new Object());
		//		list.add(new A());
		//		list.add(new B1());
		//		list.add(new B2());
		//		list.add(new C());
		Object obj = list.get(0);
		//A obj2 = list.get(0);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));

	}

	public static void main(String[] args) {
		//m1(ArrayList<?>);
		//		m1(new ArrayList());
		//		m1(new ArrayList<>());
		//		m1(new ArrayList<Object>());
		//		m1(new ArrayList<A>());
		//		m1(new ArrayList<B1>());
		//		m1(new ArrayList<B2>());
		//		m1(new ArrayList<C>());

		ArrayList<B1> my1 = new ArrayList<>();
		my1.add(new B1());
		my1.add(new B1());
		my1.add(new B1());
		m1(my1);
	}


}
