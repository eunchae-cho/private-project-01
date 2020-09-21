package com.io.ex02;

import java.io.FileOutputStream;

public class Exam0510 {
	public static void main(String[] args) throws Exception {

		String str = new String("AB가각");

		// 문자열을 담은 byte[] 리턴
		// => String.getBytes()

		System.out.printf("file.encoding=%s\n",System.getProperty("file.encoding"));

		byte[] bytes = str.getBytes();
		for (byte b : bytes) {
			System.out.printf("%x ",b);
		}

		FileOutputStream out = new FileOutputStream("temp/utf.txt");
		out.write(bytes);
		out.close();
		System.out.println("\n데이터 출력 완료");
	}
}
