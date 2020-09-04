package com.desigh_pattern.singleton;


class Car1 {
	String model;
	int cc;
}

public class Test01 {
	public static void main(String[] args) {
		Car1 c1 = new Car1();
		Car1 c2 = new Car1();
		System.out.println(c1 == c2);
	}
}
