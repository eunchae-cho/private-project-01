package com.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0130 {
	public static void main(String[] args) {

		try (Scanner keyScan = new Scanner(System.in);
				Socket socket = new Socket("localhost", 8888);
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				DataInputStream in = new DataInputStream(socket.getInputStream());) {

			System.out.println("서버와 연결되었음");
			System.out.print("> ");
			keyScan.nextLine();

			out.writeInt(1567891234);
			System.out.println("서버에 데이터를 보냈음");

			int value = in.read();
			System.out.println(value);

			keyScan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
