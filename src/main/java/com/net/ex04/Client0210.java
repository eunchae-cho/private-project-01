package com.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);

		while (true) {
			System.out.print("이름? ");
			String name = keyScan.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			try (Socket socket = new Socket("localhost", 8888);
					PrintWriter out = new PrintWriter(socket.getOutputStream());
					BufferedReader in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));) {

				System.out.println("서버와 연결되었음");

				out.println(name);
				out.flush();

				String str = in.readLine();
				System.out.println(str);

				System.out.println("서버와의 연결 끊음");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		keyScan.close();
	}
}
