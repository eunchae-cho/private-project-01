package com.oop.ex08;

public class Exam01 {
	public static void main(String[] args) {

		Sedan s = new Sedan();
		Truck t = new Truck();

		s.start();
		t.start();
		s.shutdown();
		t.shutdown();
		s.run();
		t.run();
		t.dump();

	}
}
