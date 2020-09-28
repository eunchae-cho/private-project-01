package com.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// byte Stream

public class Client0111 {
	public static void main(String[] args) {
		try (Scanner keyScan = new Scanner(System.in);
				Socket socket = new Socket("localhost", 8888);
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();) {

			System.out.println("서버와 연결되었음");
			System.out.println("소켓을 통해 입출력 스트림을 준비하였음");

			System.out.print("> ");
			keyScan.nextLine();

			out.write(100);
			System.out.println("서버에 데이터를 보냈음");

			int response = in.read();
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
