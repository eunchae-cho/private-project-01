package com.io.ex07;

import java.io.ByteArrayInputStream;

public class Exam0110 {
	public static void main(String[] args) throws Exception {
		byte[] buf = {
				0x0b, 0x41, 0x42, (byte) 0xea, (byte) 0xb0, (byte) 0x80, (byte) 0xea, (byte) 0xb0,
				(byte) 0x81, (byte) 0xea, (byte) 0xb0, (byte) 0x84, 0x00, 0x00, 0x00, 0x1b, 0x01};

		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		int b;

		while (true) {
			if ((b = in.read()) == -1)
				break;
			System.out.printf("%x ", b);
		}
		System.out.println();
		in.close();
	}
}
