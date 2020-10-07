package com.concurrent.ex03;

import java.util.Scanner;

public class Exam0310 {
	static class MyThread extends Thread {
		@Override
		public void run() {
			Scanner keyScan = new Scanner(System.in);
			System.out.print("입력하시오> ");
			String input = keyScan.nextLine();
			System.out.println("입력한 문자열 => " + input);
			keyScan.close();
		}
	}

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();

		System.out.println("프로그램 종료?");
	}

}
