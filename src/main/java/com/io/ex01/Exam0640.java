package com.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0640 {
	public static void main(String[] args) throws Exception {


		File dir = new File(".");
		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.isFile() && file.getName().endsWith(".java")) {
					return true;
				}
				return false;
			}
		});
		for (File file : files) {
			System.out.println(file.getName());
		}

	}
}
