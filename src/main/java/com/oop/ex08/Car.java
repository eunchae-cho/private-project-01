package com.oop.ex08;

public abstract class Car {

	public Car() {
		super();
	}

	public void start() {
		System.out.println("시동 건다!");
	}

	public void shutdown() {
		System.out.println("시동 끈다!");
	}

	public abstract void run();
}

