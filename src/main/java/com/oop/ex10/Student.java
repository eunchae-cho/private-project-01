package com.oop.ex10;

public abstract class Student {

	public void introduce() {
		greeting();
		speaking();
		expacting();
	}

	public abstract void greeting();
	public abstract void speaking();
	public abstract void expacting();

}
