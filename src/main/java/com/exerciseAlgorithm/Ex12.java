package com.exerciseAlgorithm;
//두 정수 A와 B를 입력받은 다음, A+B를 출력
//각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다.
//x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.

import java.util.Scanner;

public class Ex12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int COUNT = 5;
    int[] arrA = new int[COUNT];
    int[] arrB = new int[COUNT];
    int i;

    for(i = 0; i < COUNT; i++) {
      System.out.printf("(%d) 두 개의 정수값을 입력하세요(예: 10 20): ",i+1);
      arrA[i] = sc.nextInt();
      arrB[i] = sc.nextInt();
    }
    System.out.println();
    for(i = 0; i < COUNT; i++) {
      System.out.println("Case #"+(i+1)+": "+arrA[i]+" + "+arrB[i]+" = "+arrA[i]+arrB[i]);
    }
  }


}
