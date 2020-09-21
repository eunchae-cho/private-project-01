package com.io.ex02;

import java.io.FileInputStream;

public class Exam0220 {
	public static void main(String[] args) throws Exception {

		FileInputStream in = new FileInputStream("temp/test.data");
		byte[] buf = new byte[100];
		int count = in.read(buf, 10, 40);
		in.close();
		System.out.printf("읽는 바이트 수: %d\n",count);
		for (int i = 0; i < 20; i++) {
			System.out.printf("%x ", buf[i]);
		}
	}

}
