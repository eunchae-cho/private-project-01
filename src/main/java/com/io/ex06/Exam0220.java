package com.io.ex06;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0220 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/jls11.pdf");
		FileOutputStream out = new FileOutputStream("temp/jls11_3.pdf");

		byte[] buf = new byte[8192];
		int len = 0;

		long startTime = System.currentTimeMillis();

		while ((len = in.read(buf)) != -1){
			out.write(buf, 0 ,len);
		}

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
		in.close();
		out.close();
	}
}
