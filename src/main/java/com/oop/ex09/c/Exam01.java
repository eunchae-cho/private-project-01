package com.oop.ex09.c;

public class Exam01 implements B {

	@Override
	public void m2() {} //B
	@Override
	public void m1() {} //A

	public void x1() {}
	public void x2() {}

	public static void main(String[] args) {

		Exam01 obj = new Exam01();
	}
}
