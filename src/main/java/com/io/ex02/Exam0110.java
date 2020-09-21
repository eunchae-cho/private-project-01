package com.io.ex02;

import java.io.FileOutputStream;

public class Exam0110 {
	public static void main(String[] args) throws Exception {

		FileOutputStream out = new FileOutputStream("temp1/a.data");
		out.write(0x7a6b5c4d);
		out.close();
		System.out.println("데이터 출력 완료");

	}
}
