package com.io.ex02;

import java.io.FileInputStream;

public class Exam0320 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("temp/test.data");
		byte[] bytes = new byte[100];
		int count = in.read(bytes, 10, 40);
		in.close();
		System.out.printf("%d\n",count);

		for (int i = 0; i < 20; i++) {
			System.out.printf("%x ",bytes[i]);
		}
		System.out.println();
	}
}
