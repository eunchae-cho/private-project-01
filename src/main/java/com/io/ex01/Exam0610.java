package com.io.ex01;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0610 {

	public static void main(String[] args) throws Exception {

		class MyFilenameFilter implements FilenameFilter {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".java")) {
					return true;
				}
				return false;
			}
		}

		File dir = new File(".");
		MyFilenameFilter filter = new MyFilenameFilter();
		String[] names = dir.list(filter);
		for (String name : names) {
			System.out.println(name);
		}
	}

}
