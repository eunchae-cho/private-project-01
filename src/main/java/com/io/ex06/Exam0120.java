package com.io.ex06;

import java.io.FileInputStream;

public class Exam0120 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/jls11.pdf");
		byte[] bytes = new byte[8192];
		int len = 0;
		long startTime = System.currentTimeMillis();
		int callCount = 0;
		while ((len = in.read(bytes)) != -1) {
			callCount++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
		System.out.println(callCount);
		in.close();
	}

}
