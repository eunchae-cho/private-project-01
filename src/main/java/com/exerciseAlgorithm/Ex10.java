package com.exerciseAlgorithm;
// 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 거꾸로 하나씩 출력

import java.util.Scanner;

public class Ex10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("n을 입력하세요: ");
    int n = sc.nextInt();

    for (int i = n; i >= 1; i--) {
      System.out.println(i);
    }

  }
}
