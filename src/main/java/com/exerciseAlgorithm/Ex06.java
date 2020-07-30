package com.exerciseAlgorithm;

import java.util.Scanner;

//두 정수 A와 B를 입력받은 다음, A+B를 출력



public class Ex06 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arrA = new int[5];
    int[] arrB = new int[5];
    int[] num = new int[5];
    int i;

    for (i = 0; i < 5; i++) {
      System.out.print("a = ");
      arrA[i] = sc.nextInt();
      System.out.print("b = ");
      arrB[i] = sc.nextInt();
      int sum = arrA[i] + arrB[i];
      num[i] = sum;
      }
    System.out.println();
    System.out.println(num[i]);
    }

  }

