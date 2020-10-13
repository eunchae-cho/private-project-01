package com.concurrent.ex05;

public class Exam110 {
	public static void main(String[] args) {
		Account account = new Account("111-11-11111", 1_000_000);

		ATM 강남 = new ATM("강남", account);
		ATM 서초 = new ATM("서초", account);
		ATM 부산 = new ATM("부산", account);
		ATM 대전 = new ATM("대전", account);
		ATM 광주 = new ATM("광주", account);

		강남.start();
		서초.start();
		부산.start();
		대전.start();
		광주.start();
	}
}
