package com.exception.ex03;

import java.io.FileReader;
import java.util.Scanner;

public class Exam0630 {
	static void m() throws Exception {
		// try-with-resource
		// try (java.lang.AutoCloseable 구현체)
		// finally close() 대신 자동 처리 해줌

		try (Scanner keyScan = new Scanner(System.in);
				FileReader in = new FileReader("Hello.java");
				// 반드시 AutoCloneable 구현체여야 한다.
				// 변수 선언만 올 수 있음
				) {
			System.out.print("입력> ");
			int value = keyScan.nextInt();
			System.out.println(value * value);
		}
	}

	public static void main(String[] args) throws Exception {
		m();
	}
}
