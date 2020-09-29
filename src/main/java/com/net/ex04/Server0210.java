package com.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server0210 {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8888);) {
			System.out.println("서버 실행");
			while (true) {
				try (Socket socket = serverSocket.accept();
						PrintWriter out = new PrintWriter(socket.getOutputStream());
						BufferedReader in = new BufferedReader(new InputStreamReader(
								socket.getInputStream()));) {

					System.out.println("클라이언트와 연결됨");

					String name = in.readLine();
					out.printf("%s님 반갑습니다.", name);
					out.flush();

				} catch (Exception e) {
					System.out.println("클라이언트와 통신 중 오류 발생");
				}
				System.out.println("클라이언트와의 연결을 끊었음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("서버 종료");
	}

}
