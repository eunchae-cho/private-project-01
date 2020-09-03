package com.oop.ex10;

public class StudentExample {
	public static void main(String[] args) {

		Hong h = new Hong();
		Kim k = new Kim();

		meeting(h);
		System.out.println("----------------------");
		meeting(k);

	}

	static void meeting(Student student) {
		student.introduce();
	}
}
