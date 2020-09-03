package com.oop.ex10;

public class Restaurant extends Building{

	@Override
	public void startEffect() {
		System.out.println("배고프다");
	}

	@Override
	public void endEffect() {
		System.out.println("배부르다");
	}
}
