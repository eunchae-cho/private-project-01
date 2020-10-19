package com.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exam0510 {

	static class MyRunnable implements Runnable {
		int millisec;

		public MyRunnable(int millisec) {
			this.millisec = millisec;
		}

		@Override
		public void run() {
			try {
				System.out.printf("%s 스레드 실행 중...\n", Thread.currentThread().getName());

				Thread.sleep(millisec);

				System.out.printf("%s 스레드 실행 종료\n", Thread.currentThread().getName());
			} catch (Exception e) {
				System.out.printf("스레드 실행중 오류 발생 - %s\n", Thread.currentThread().getName());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		executorService.execute(new MyRunnable(11000));
		executorService.execute(new MyRunnable(2000));
		executorService.execute(new MyRunnable(4000));
		executorService.execute(new MyRunnable(5000));

		executorService.shutdown();

		if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
			System.out.println("아직 종료 하지 않은 작업이 있음");
			System.out.println("남아 있는 작업 강제 종료 시작");
			executorService.shutdownNow();
		}

		if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
			System.out.println("스레드풀 강제 종료를 완료하지 못함");
		} else {
			System.out.println("모든 작업 종료");
		}
		System.out.println("main() 종료");

	}
}
