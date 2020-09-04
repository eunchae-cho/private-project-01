package com.oop.ex09.a;

public class WorkerExample {
	public static void main(String[] args) {

		Worker w1 = new BlueWorker();
		Worker w2 = new WhiteWorker();
		Worker w3 = new AnotherWorker();

		w1.execute();
		w2.execute();
		w3.execute();
	}

}
