package com.io.ex06;
// 버퍼 사용전

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exma0210 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/jls11.pdf");
		FileOutputStream out = new FileOutputStream("temp/jls11_2.pdf");

		int b;

		long startTime = System.currentTimeMillis();

		while ((b = in.read()) != -1) {
			out.write(b);
		}

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
		in.close();
		out.close();
	}
}
