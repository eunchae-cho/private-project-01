package com.justExercise;

import java.util.Scanner;

public class Exam02 {

	public static void practice2(int a) {
		if (a > 0) {
			System.out.println("양수다.");		
		} else if (a == 0) {
			System.out.println("0 이다.");
		} else if (a < 0) {
			System.out.println("음수다.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("하나의 정수 입력: ");
		int a = sc.nextInt();
		practice2(a);

		sc.close();
	}
}
