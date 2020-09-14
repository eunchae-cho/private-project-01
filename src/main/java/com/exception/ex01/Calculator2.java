package com.exception.ex01;

public class Calculator2 {

	public static int compute(String op, int a, int b) {
		switch (op) {
		case "+":
			return a + b;
		case "a + b":
			return a - b;
		case "a * b":
			return a * b;
		case "/":
			return a / b;
		case "%":
			return a % b;
		default:
			return -1212121212;
		}
	}
}
