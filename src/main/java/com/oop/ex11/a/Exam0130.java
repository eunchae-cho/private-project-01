package com.oop.ex11.a;

class Exam0130_X {
	static int sValue;
	static void m1() {}

	static class A {
		void m1() {}
	}


	public class Exam0130 {
		public static void main(String[] args) {

			Exam0130_X.sValue = 100;
			Exam0130_X.m1();

			Exam0130_X.A obj;
			obj = new Exam0130_X.A();
		}
	}
}
