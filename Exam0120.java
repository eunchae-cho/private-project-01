package com.io.ex01;

import java.io.File;

public class Exam0120 {
	public static void main(String[] args) throws Exception {
		// File 클래스
		// 파일이나 디렉토리 정보를 관리
		// 파일이나 디렉토리 생성,삭제,변경

		File currentDir = new File("./src/main/java/../../test/java");
		System.out.printf("폴더명: %s\n", currentDir.getName());
		System.out.printf("경로: %s\n", currentDir.getPath());
		System.out.printf("절대경로: %s\n", currentDir.getAbsolutePath());
		System.out.printf("계산된 절대경로: %s\n", currentDir.getCanonicalPath());

		System.out.printf("크기: %s\n", currentDir.getTotalSpace());
		System.out.printf("남은크기: %s\n", currentDir.getFreeSpace());
		System.out.printf("가용크기: %s\n", currentDir.getUsableSpace());

		System.out.printf("디렉토리여부: %s\n", currentDir.isDirectory());
		System.out.printf("파일여부: %s\n", currentDir.isFile());
		System.out.printf("감춤폴더: %s\n", currentDir.isHidden());
		System.out.printf("존재여부: %s\n", currentDir.exists());
		System.out.printf("실행가능여부: %s\n", currentDir.canExecute());
	}
}
