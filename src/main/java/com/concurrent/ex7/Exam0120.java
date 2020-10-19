package com.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0120 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		executorService.execute(() -> 	System.out.printf("%s 스레드 실행", 
				Thread.currentThread().getName()));

		executorService.shutdown();
		System.out.println("main() 종료");
	}
}
