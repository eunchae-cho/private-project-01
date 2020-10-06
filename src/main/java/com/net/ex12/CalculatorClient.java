package com.net.ex12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);
		System.out.println("[비트캠프 계산기]");
		System.out.println("계산식을 입력하세요. 예) 23 + 7");

		while (true) {

			String input = prompt(keyScan);
			if (input == null) {
				continue;
			} else if (input.equalsIgnoreCase("quit")) {
				System.out.println("계산기를 종료합니다.");
				break;
			}

			try (Socket socket = new Socket("localhost", 8888);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintStream out = new PrintStream(socket.getOutputStream());) {

				sendRequest(out,input);
				receiveResponse(in);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static String prompt(Scanner keyScan) {
		System.out.print("계산식> ");
		String input = keyScan.nextLine();

		if (input.equalsIgnoreCase("quit")) {
			return input;
		} else if (input.split(" ").length != 3) {
			System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 7");
			return null;
		}
		return input;
	}

	static void sendRequest(PrintStream out, String message) {
		out.println(message);
		out.flush();
	}

	static void receiveResponse(BufferedReader in) throws Exception {
		while (true) {
			String input = in.readLine();
			if (input.length() == 0) {
				break;
			}
			System.out.println(input);
		}
	}

}
