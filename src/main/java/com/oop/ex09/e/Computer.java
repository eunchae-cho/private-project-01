package com.oop.ex09.e;

public interface Computer {
	void compute();
	default void touch() {}
}
