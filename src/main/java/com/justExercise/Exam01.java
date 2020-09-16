package com.justExercise;

import java.util.Scanner;

public class Exam01 {

	public static void practice1(int a) {
		if (a > 0)
			System.out.println("양수다.");
		else
			System.out.println("양수가 아니다.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("하나의 정수 입력: ");
		int a = sc.nextInt();
		practice1(a);

		sc.close();
	}
}
