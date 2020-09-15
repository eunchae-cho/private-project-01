package com.io.ex01;

import java.io.File;

public class Exam0321 {
	public static void main(String[] args) {
		File dir = new File("temp2/a");
		if (dir.mkdir()) { // 디렉토리 생성
			System.out.println("temp2/a 디렉토리를 생성하였습니다.");
		} else {
			System.out.println("temp2/a 디렉토리를 생성할 수 없습니다.");
		}
	}

}
