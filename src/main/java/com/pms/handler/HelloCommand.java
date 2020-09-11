package com.pms.handler;

public class HelloCommand implements Command {
	@Override
	public void execute() {
		System.out.println("Hello ^o^");
	}
}
