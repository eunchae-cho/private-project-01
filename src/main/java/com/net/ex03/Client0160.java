package com.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0160 {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);

		try (Socket socket = new Socket("localhost", 8888);
				PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
				Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
				){

			System.out.println("서버와 연결되었음");

			System.out.print(">");
			keyScan.nextLine();

			out.println("ABC가각간");


		} catch (Exception e) {
			e.printStackTrace();
		}
		keyScan.close();
	}
}
