package com.desigh_pattern.singleton;


class Car2{
	String mode;
	int cc;
	private static Car2 instance;

	private Car2() {}

	public static Car2 getInstance() {
		if (Car2.instance == null) {
			Car2.instance = new Car2();
		}
		return Car2.instance;
	}
}

public class Test02 {
	public static void main(String[] args) {
		//Car2 c1 = new Car2();

		Car2 c1 = Car2.getInstance();
		Car2 c2 = Car2.getInstance();
		System.out.println(c1 == c2);
	}
}
