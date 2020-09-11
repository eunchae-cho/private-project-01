package com.oop.ex11.c;


class E {
	class X{

	}
}

public class Exam0510 {
	public static void main(String[] args) {
		E outer = new E();
		E.X obj = outer.new X();
	}
}
