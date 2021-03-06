package com.concurrent.ex02;

public class Exam0180 {
	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread();
		ThreadGroup mainGroup = mainThread.getThreadGroup();
		ThreadGroup systemGroup = mainGroup.getParent();

		printThreads(systemGroup, "");
	}

	static void printThreads(ThreadGroup tg, String indent) {
		System.out.println(indent + tg.getName() + "(TG)");

		Thread[] threads = new Thread[10];
		int size = tg.enumerate(threads, false);
		for (int i = 0; i < size; i++) {
			System.out.println(indent + " ==> " + threads[i].getName() + "(T)");
		}

		ThreadGroup[] groups = new ThreadGroup[10];
		size = tg.enumerate(groups, false);
		for (int i = 0; i < size; i++) {
			printThreads(groups[i], indent + " ");
		}
	}
}
