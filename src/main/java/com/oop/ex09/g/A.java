package com.oop.ex09.g;

public interface A {

	static String m1() {
		return "안녕하세요";
	}

	default void m2() {
	}

	void m3();

}
