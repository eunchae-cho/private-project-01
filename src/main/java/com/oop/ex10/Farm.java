package com.oop.ex10;

public class Farm extends Building {
	@Override
	public void startEffect() {
		System.out.println("씨를 심어요");
	}

	@Override
	public void endEffect() {
		System.out.println("재배해요");
	}
}
