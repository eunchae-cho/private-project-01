package com.io.ex01;

import java.io.File;

public class Exam0330 {
	public static void main(String[] args) throws Exception {
		File dir = new File("temp");
		if (dir.delete()) { 
			System.out.println("temp 디렉토리를 삭제하였습니다.");
		} else {
			System.out.println("temp 디렉토리를 삭제할 수 없습니다.");
		}
	}

}
