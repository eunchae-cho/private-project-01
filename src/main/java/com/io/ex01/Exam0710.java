package com.io.ex01;

import java.io.File;

public class Exam0710 {
	public static void main(String[] args) {
		// 1) 파일 기능 코드 작성하기
		// 2) 그 기능을 메서드로 분리
		// 3) 메소드 추출하기 - extract method

		File dir = new File(".");
		printFiles(dir, 0);
	}

	static void printFiles(File dir, int level) {
		File[] files = dir.listFiles();
		printIndent(level);
		for (File file : files) {
			// 재귀 호출
			if (file.isDirectory()) {
				printFiles(file,level + 1); // 자기 자신의 메소드로 재호출
			}
			System.out.println(file.getName());
		}
	}

	static void printIndent(int level) {
		for (int i = 0; i <= level; i++) {
			System.out.print("  ");
		}
		System.out.println("└─ ");
	}
}
