package com.net.ex10;


import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam0120 {
	public static void main(String[] args) throws Exception {
		File file = new File("./sample/test1.jpg");
		FileInputStream in = new FileInputStream(file);
		byte[] bytes = in.readAllBytes();
		in.close();

		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(bytes);
		System.out.println(new String(encodedBytes));
	}
}
