package com.oop.ex09.h;

public class Exam01 {
	public static void main(String[] args) {
		Car c = new Tico();

		if(CarCheckInfo.validate(c)) {
			c.start();
			c.run();
			c.shutdown();
		} else {
			System.out.println("자동차를 점검하시요");
		}
	}
}
