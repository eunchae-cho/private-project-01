package com.oop.ex11.e;

public class Exam0440 {

	interface A{
		void print();
	}

	void m1(A obj) {
		obj.print();
	}

	public static void main(String[] args) {
		Exam0440 r =new Exam0440();
		r.m1(new A(){
			@Override
			public void print() {
				System.out.println("안녕");
			}
		});
	}
}
