package com.oop.ex11.a;

public class Exam0120 {

	static class A {
		void m1() {
		}
	}

	// static Method kann selbst in Static Method einlassen.
	static void m1() {
		A obj;
		obj = new A();
	}

	// Static Method darf auch in Instance Methoed reinschreiben lassen.
	void m2() {
		A obj;
		obj = new A();
	}

	public static void main(String[] args) {

	}

}
