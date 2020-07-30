package com.exerciseAlgorithm;

import java.util.Scanner;

// 구구단

public class Ex05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("\n숫자를 입력하세요: ");
    int num = sc.nextInt();

    System.out.println("\n [ "+num+"단 ] ");
    for (int i = 1; i <= 9; i++) {
      System.out.printf("%d * %d = %d\n",num,i,num*i);

    }
  }

}
