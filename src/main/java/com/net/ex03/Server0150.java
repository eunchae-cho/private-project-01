package com.net.ex03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0150 {
	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in);
				ServerSocket serverSocket = new ServerSocket(8888);) {
			System.out.println("클라이언트의 연결을 기다리고 있음");

			try (Socket socket = serverSocket.accept();
					Scanner in = new Scanner(socket.getInputStream());
					PrintStream out = new PrintStream(socket.getOutputStream());) {
				System.out.println("클라이언트가 보낸 한 줄의 문자열을 기다리고 있음");

				String str = in.nextLine();
				out.println(str);

				out.print("> ");
				keyboard.nextLine();

				out.println(str);
				System.out.println("클라이언트와의 연결을 끊었음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("서버 종료");
	}
}
