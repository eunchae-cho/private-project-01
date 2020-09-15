package com.io.ex01;

import java.io.File;

public class Exam0431 {
	public static void main(String[] args) throws Exception {

		File file = new File("temp2/b/test.txt");
		File dir = file.getParentFile();

		if (dir.mkdirs()) {
			System.out.println("디렉토리를 생성하였습니다.");
		} else {
			System.out.println("디렉토리를 생성할 수 없습니다.");
		}

		if (file.createNewFile()) { // 파일 생성
			System.out.println("test.txt 파일을 생성하였습니다.");
		} else {

			System.out.println("test.txt 파일을 생성할 수 없습니다.");
		}


	}
}
