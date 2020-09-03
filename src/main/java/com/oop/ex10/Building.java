package com.oop.ex10;

public abstract class Building {

	public void build() {
		System.out.print("건축 시작: ");
		startEffect();

		System.out.print("건축 완료: ");
		endEffect();
	}

	public abstract void startEffect();
	public abstract void endEffect();

}
