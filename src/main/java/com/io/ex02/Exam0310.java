package com.io.ex02;

import java.io.FileOutputStream;

public interface Exam0310 {
	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("temp/test.data");
		byte[] bytes = new byte[] {0x7a, 0x6b, 0x4d, 0x3e, 0x2f, 0x30};
		out.write(bytes, 2, 3);
		out.close();
		System.out.println("데이터 출력 완료");
	}
}

