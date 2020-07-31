package com.exerciseAlgorithm;
// while을 이용하여 정수 a와 b를 받고 a+b값 출력하기

import java.util.Scanner;

public class Ex13 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int LENGTH = 6;
    int[] arrA = new int[LENGTH];
    int[] arrB = new int[LENGTH];
    int count = 0;
    int a, b;

    while (count < LENGTH) {
      System.out.printf("(%d) 정수 a와 b를 입력해주세요(0<a,b<10): ",count+1);
      arrA[count] = sc.nextInt();
      arrB[count] = sc.nextInt();
      count++;
    }
    while(count < LENGTH) {
      System.out.println(arrA[count]+" "+arrB[count]);
      count++;
    }
  }
}
