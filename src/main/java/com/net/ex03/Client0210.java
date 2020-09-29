package com.net.ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);

		try (Socket socket = new Socket("localhost", 8888);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));) {

			System.out.println("서버에 연결되었음");

			System.out.print("> ");
			keyScan.nextLine();

			out.println("ABC가각간");
			out.flush();
			System.out.println("서버에 데이터 보냈음");

			String str = in.readLine();
			System.out.println(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		keyScan.close();
	}
}
