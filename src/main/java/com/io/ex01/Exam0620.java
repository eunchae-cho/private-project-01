package com.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0620 {
	public static void main(String[] args) throws Exception {

		class MyFileFilter implements FileFilter {
			@Override
			public boolean accept(File file) {
				if (file.isFile() && file.getName().endsWith(".java")) {
					return true;
				}
				return false;
			}
		}


		File dir = new File(".");
		MyFileFilter filter = new MyFileFilter();
		File[] files = dir.listFiles(filter);
		for (File file : files) {
			System.out.println(file.getName());
		}

	}
}
