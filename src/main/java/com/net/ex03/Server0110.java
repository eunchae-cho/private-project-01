package com.net.ex03;
// byte Stream

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0110 {
	public static void main(String[] args) {
		Scanner keyboard = null;
		ServerSocket ss = null;

		try {
			keyboard = new Scanner(System.in);
			ss = new ServerSocket(8888);
			System.out.println("클라이언트의 연결을 기다리고 있음");

			Socket socket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				socket = ss.accept();
				System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성");

				out = socket.getOutputStream();
				in = socket.getInputStream();
				System.out.println("클라이언트와 통신할 입출력 스트림이 준비됨");
				System.out.println("클라이언트가 보낸 1바이트를 기다리고 있음");
				int request = in.read();
				System.out.println(request);

				System.out.print("데이터를 보내기 전에 잠깐...!");
				keyboard.nextLine();

				out.write(request);
				System.out.println("클라이언트에게 데이터를 보냈음");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { in.close();} catch (Exception e) {}
				try { out.close();} catch (Exception e) {}
				try { socket.close();} catch (Exception e) {}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { keyboard.close();} catch (Exception e) {}
			try { ss.close();} catch (Exception e) {}
		}
	}
}
