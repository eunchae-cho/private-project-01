package com.oop.ex10;

public class BuildingExample {

	public static void main(String[] args) {

		Restaurant r = new Restaurant();
		Farm f = new Farm();

		work(r);
		System.out.println("-----------");
		work(f);

	}

	static void work(Building obj) {
		obj.build();
	}

}
