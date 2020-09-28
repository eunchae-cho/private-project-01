package com.net.ex02;

import java.net.Socket;
import java.util.Scanner;

public class Client0210 {

	public static void main(String[] args) throws Exception {
		Scanner keyScan = new Scanner(System.in);
		System.out.println("클라이언트 실행!");
		Socket socket = new Socket("localhost", 8888);
		System.out.println("서버에 연결됨!");
		keyScan.nextLine();
		socket.close();
		System.out.println("서버와의 연결을 끊었음!");
		keyScan.close();

	}
}
