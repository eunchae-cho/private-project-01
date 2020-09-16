package com.oop.ex12;


public class Exam0330 {


	static interface Calculator {
		int compute(int a, int b);
	}

	static void test(Calculator c) {
		System.out.println(c.compute(100, 200));
	}

	public static void main(String[] args) {

	}
}
