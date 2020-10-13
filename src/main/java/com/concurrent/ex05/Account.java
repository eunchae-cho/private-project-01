package com.concurrent.ex05;

public class Account {
	String accountID;
	long balance;

	public Account(String accountID, long balance) {
		this.accountID = accountID;
		this.balance = balance;
	}

	synchronized public long withdraw(long money) {
		long b = this.balance;
		b -= money;

		if (b < 0) {
			return 0;
		}
		this.balance = b;
		return money;

	}
}
