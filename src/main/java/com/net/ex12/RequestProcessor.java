package com.net.ex12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RequestProcessor extends Thread{
	Socket socket;

	public RequestProcessor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket;
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				PrintStream out = new PrintStream(socket.getOutputStream());) {

			String requestLine = in.readLine();

			while (true) {
				if (in.readLine().length() == 0) {
					break;
				}
			}

			sendHttpResponse(out,compute(requestLine));

		} catch (Exception e) {
			System.out.printf("클라이언트 요청 처리 중 오류 발생 - %s", e.getMessage());
		}
	}

	private String getOperator(String op) {
		switch (op) {
		case "/plus": return "+";
		case "/minus": return "-";
		case "/multiple": return "*";
		case "/divide": return "/";
		default: return "?";
		}
	}


	private String compute(String request) {
		try {
			String[] values = request.split(" ")[1].split("\\?");
			String op = getOperator(values[0]);
			String[] parameters = values[1].split("&");

			int a = 0;
			int b = 0;
			for (String parameter : parameters) {
				String[] kv = parameter.split("=");
				if (kv[0].equals("a")) {
					a = Integer.parseInt(kv[1]);
				} else if (kv[0].equals("b")) {
					b = Integer.parseInt(kv[1]);
				}
			}

			int result = 0;

			switch (op) {
			case "+": result = a + b; break;
			case "-": result = a - b; break;
			case "*": result = a * b; break;
			case "/": result = a / b; break;
			default:
				return String.format("%s 연산자를 지원하지 않습니다.\n", op);
			}
			return String.format("결과는 %d %s %d = %d 입니다.\n", a, op, b, result);
		} catch (Exception e) {
			return String.format("계산 중 오류 발생 - %s\n", e.getMessage());
		}
	}

	private void sendHttpResponse(PrintStream out, String message) {
		out.println("HTTP/1.1 200 OK");
		out.println("Content-Type: text/plain;charset=UTF-8");
		out.println();
		out.print(message);
		out.flush();
	}


}
