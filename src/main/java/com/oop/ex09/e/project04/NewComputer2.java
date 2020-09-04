package com.oop.ex09.e.project04;

import com.oop.ex09.e.Computer;

public class NewComputer2 implements Computer{
	public void compute() {
		System.out.println("새 컴퓨터..!");
	}

	public void touch() {
		System.out.println("터치 기능 추가");
	}
}
