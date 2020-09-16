package com.oop.ex12;

public class Exam0620 {

	static class Calculator{
		double rate;

		public Calculator(double rate) {
			this.rate = rate;
		}

		public double year(int money) {
			return money * rate / 100;
		}

		public double month(int money) {
			return money * rate / 100 / 12;
		}

		public double day(int money) {
			return money * rate / 100 / 365;
		}
	}

	static interface Interest {
		double compute(int money);
	}

	public static void main(String[] args) {

		Calculator 보통예금 = new Calculator(0.5);
		Interest i = 보통예금::year;
		System.out.printf("연 이자 : %.1f\n",i.compute(100_000_000));
	}
}
