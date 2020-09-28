package com.net.ex02;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server0210 {
	public static void main(String[] args) throws Exception {
		Scanner keyScan = new Scanner(System.in);
		System.out.println("서버 실행");

		ServerSocket ss = new ServerSocket(8888);
		System.out.println("서버 소켓 생성 완료");
		System.out.println("클라이언트 연결을 기다리는 중");

		keyScan.nextLine();
		ss.close();
		System.out.println("서버 종료");
		keyScan.close();
	}
}
