package com.exerciseAlgorithm;
// 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력


import java.util.Scanner;

public class Ex08 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("n = ");
    int n = sc.nextInt();
    int count = 1;
    int sum = 0;

    while (count <= n) {
      sum += count;
      count++;
    }
    System.out.println("n의 합: "+sum);
  }
}
