package com.oop.ex08;

public class Sedan extends Car{

	@Override
	public void run() {
		System.out.println("쌩쌩 달린다!");
	}

	public void doSunRoof(boolean open) {
		if (open) {
			System.out.println("열린다!");
		} else {
			System.out.println("닫힌다!");
		}
	}
}
