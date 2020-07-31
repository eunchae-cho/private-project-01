package com.exerciseAlgorithm;


//두 정수 A와 B를 입력받은 다음, A+B를 출력
//테스트 케이스는 한 줄로 이루어져 있으며,
//각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다.
//테스트 케이스 번호는 1부터 시작한다.

import java.util.Scanner;

public class Ex11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int COUNT = 5;
    int[] arrA = new int[COUNT];
    int[] arrB = new int[COUNT];
    int i;

    for (i = 0; i < COUNT; i++) {
      System.out.printf("(%d) 두 개의 정수값을 입력하세요(예: 20 30): ",i+1);
      arrA[i] = sc.nextInt();
      arrB[i] = sc.nextInt();
    }
    System.out.println();
    for ( i = 0; i < COUNT; i++) {
      System.out.printf("Case #%d: %d\n",i+1,arrA[i]+arrB[i]);
    }
  }
}
