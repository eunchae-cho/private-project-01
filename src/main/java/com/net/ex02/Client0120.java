package com.net.ex02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// byte array 주고 받기

public class Client0120 {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);

		try (Socket socket = new Socket("local", 8888);
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();) {

			System.out.println("서버와 연결되었음");
			System.out.print("> ");
			keyScan.nextLine();

			byte[] bytes = new byte[100];
			for (int i = 0; i < 100; i++) {
				bytes[i] = (byte) i;
			}

			out.write(bytes);
			System.out.println("서버에 데이터를 보냈음");

			byte[] buf = new byte[100];
			int size = in.read(buf);
			System.out.printf("바이트 배열의 크기: %d\n", size);
			for (int i = 0; i < size; i++) {
				if (i > 0 && i % 20 == 0) {
					System.out.println();
				}
				System.out.printf("%x", buf[i]);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		keyScan.close();
	}
}
