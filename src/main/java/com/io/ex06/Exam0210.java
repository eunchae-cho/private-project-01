package com.io.ex06;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0210 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/jls11.pdf");
		FileOutputStream out = new FileOutputStream("temp/jls11_2.pdf");
		int b;
		long startTime = System.currentTimeMillis();
		while((b = in.read()) != -1) {
			out.write(b);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		in.close();
		out.close();
	}
}
