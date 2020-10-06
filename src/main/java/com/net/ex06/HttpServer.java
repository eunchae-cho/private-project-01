package com.net.ex06;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("서버 실행");

		while (true) {
			Socket socket = ss.accept();
			Scanner in = new Scanner(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());

			while (true) {
				String str = in.next();
				System.out.println(str);
				if (str.equals(""))
					break;
			}

			out.print("HTTP/1.1 200 OK\r\n");
			out.print("Content-Yype: text/html; charset=UTF-8\r\n");
			out.print("\r\n");
			out.print("<html><body><h1>안녕 -은채</h1></body></html>\r\n");

			out.close();
			in.close();
			socket.close();
		}
	}
}
