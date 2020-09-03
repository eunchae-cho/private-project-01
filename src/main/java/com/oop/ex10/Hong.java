package com.oop.ex10;

public class Hong extends Student{

	@Override
	public void greeting() {
		System.out.println("안녕하세요.");
	}

	@Override
	public void speaking() {
		System.out.println("저는 홍길동입니다.");
	}

	@Override
	public void expacting() {
		System.out.println("잘해봅시다.");

	}
}
