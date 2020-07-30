package com.exerciseAlgorithm;
// n이 주어졌을 때, 1부터 n까지 합

import java.util.Scanner;

public class Ex07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("n = ");
    int n = sc.nextInt();
    int sum = 0;

    for(int i = 1; i <= n; i++) {
      sum += i;
    }
    System.out.println("n의 합: "+sum);
  }
}
