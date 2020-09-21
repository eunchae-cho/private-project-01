package com.io.ex06;

import java.io.FileInputStream;

public class Exam0110 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/jls11.pdf");

		long startTime = System.currentTimeMillis();
		int b;
		int callCount = 0;
		while ((b = in.read()) != -1) {
			callCount++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		System.out.println(callCount);
		in.close();
	}
}
