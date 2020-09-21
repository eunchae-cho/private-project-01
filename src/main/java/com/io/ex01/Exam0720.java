package com.io.ex01;

import java.io.File;

public class Exam0720 {
	public static void main(String[] args) {

		File dir = new File("temp2");
		deleteFile(dir);
	}

	static void deleteFile(File dir) {
		// dir.delete(); 하위폴더가 있기 때문에 지워지지 않음
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				deleteFile(file);
			}
		}
		dir.delete();
	}
}
