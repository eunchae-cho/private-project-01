package com.generic.ex01;

import java.util.ArrayList;

public class Exam0224 {

	static class A {}
	static class B1 extends A {}
	static class B2 extends A {}
	static class C extends B1 {}

	static void m1(ArrayList<? extends B1> list) {
		// 어떤 타입인지 구체적이지 않아 에러
		//list.add(new B1());
		Object obj = list.get(0);
		B1 obj2 = list.get(0);
		//C obj3 = list.get(0);
	}


	public static void main(String[] args) {
		//m1(ArrayList<? extends B1>);
		//m1(new ArrayList<Object>());
		//m1(new ArrayList<A>());
		m1(new ArrayList<B1>());
		//m1(new ArrayList<B2>());
		m1(new ArrayList<C>());
	}

}
