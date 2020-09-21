package com.io.ex04;

import java.io.FileInputStream;

public class Exam0120 {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/test3.data");
		int value = in.read();
		System.out.printf("%1x(%1$d)\n", value);
	}
}
