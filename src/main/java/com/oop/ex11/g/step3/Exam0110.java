package com.oop.ex11.g.step3;

public class Exam0110 {
	public static void main(String[] args) {
		Product p = new Product();
		p.category = "appliance/tv";
		p.name = "울트라비전 뷰";
		p.price = 2000000;

		Product p2 = new Product();
		p2.category = "computer/ram";
		p2.name = "삼성모듈램 4GE";
		p2.price = 80000;

		Product p3 = new Product();
		p3.category = "book/novel"; //book/novel 잘못 기입
		p3.name = "토지";
		p3.price = 18000;

	}
}
