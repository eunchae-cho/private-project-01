package com.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// byte Stream

public class Client0110 {
	public static void main(String[] args) {
		Scanner keyScan = null;
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;

		try {
			keyScan = new Scanner(System.in);
			socket = new Socket("localhost", 8888);
			System.out.println("서버와 연결되었음");

			out = socket.getOutputStream();

			in = socket.getInputStream();
			System.out.println("소켓을 통해 입출력 스트림을 준비하였음");

			System.out.print("> ");
			keyScan.nextLine();

			out.write(100);
			System.out.println("서버에 데이터를 보냈음");

			int response = in.read();
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { out.close();} catch (Exception e) {}
			try { in.close();} catch (Exception e) {}
			try { socket.close();} catch (Exception e) {}
		}

		keyScan.close();
	}
}
