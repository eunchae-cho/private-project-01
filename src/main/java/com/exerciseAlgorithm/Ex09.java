package com.exerciseAlgorithm;

import java.util.Scanner;

// 연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력

public class Ex09 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("n을 입력하세요: ");
    int n = sc. nextInt();

    for (int i = 1; i <= n; i++) {
      System.out.println(i);
    }
  }
}
