package com.concurrent.ex02;

public class Exam0130 {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		ThreadGroup group = t.getThreadGroup();

		Thread[] arr = new Thread[100];
		int count = group.enumerate(arr, false);

		System.out.println("그룹에 소속된 스레드들");
		for (int i = 0; i < count; i++) {
			System.out.println(" => " + arr[i].getName());
		}
	}
}
