package com.justExercise;

import java.util.Scanner;

public class Exam03 {

	public static void practice3(int a) {
		if (a % 2 == 0) {
			System.out.println("짝수다.");
		} else {
			System.out.println("홀수다.");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("하나의 정수 입력: ");
		int a = sc.nextInt();
		practice3(a);

		sc.close();
	}
}
