package com.io.ex02;

import java.io.File;
import java.io.FileInputStream;

public class Exam0410 {
	public static void main(String[] args) throws Exception {
		// 1.파일 정보 준비
		File file = new File("sample/photo.jpg");
		// 2. 파일 읽을 도구 준비
		FileInputStream in = new FileInputStream(file);
		// SOI Segment 읽기
		int b1 = in.read();
		int b2 = in.read();
		int soi = b1 << 8 | b2;
		System.out.printf("SOI: %x\n",soi);


	}
}
