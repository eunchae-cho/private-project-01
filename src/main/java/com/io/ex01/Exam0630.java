package com.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0630 {
	public static void main(String[] args) throws Exception {


		File dir = new File(".");
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.isFile() && file.getName().endsWith(".java")) {
					return true;
				}
				return false;
			}
		};
		File[] files = dir.listFiles(filter);
		for (File file : files) {
			System.out.println(file.getName());
		}

	}
}
