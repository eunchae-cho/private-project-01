package com.oop.ex11.c;


class G {
	int v1 = 100;
	int v2 = 200;
	int v3 = 300;

	class X {
		int v1 = 10;
		int v2 = 20;

		void m1(int v1) {
			System.out.println("G 객체");
			System.out.printf("G.this.v1 = %d\n",G.this.v1);
			System.out.printf("G.this.v2 = %d\n",G.this.v2);
			System.out.printf("G.this.v3 = %d\n",G.this.v3);

			System.out.println("-------------------------");

			System.out.println("G.X 객체");
			System.out.printf("this.v1 = %d\n",this.v1);
			System.out.printf("this.v2 = %d\n",this.v2);

			System.out.println("-------------------------");

			System.out.println("로컬");
			System.out.printf("v1 = %d\n",v1);
		}
	}
}
public class Exam0610 {
	public static void main(String[] args) {
		G outer = new G();
		G.X obj = outer.new X();
		obj.m1(1);
	}

}
