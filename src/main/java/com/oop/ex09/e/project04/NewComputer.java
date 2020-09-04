package com.oop.ex09.e.project04;

import com.oop.ex09.e.Computer2;

public class NewComputer implements Computer2{
	public void compute() {
		System.out.println("새 컴퓨터..!");
	}

	public void touch() {
		System.out.println("터치 기능 추가");
	}
}
