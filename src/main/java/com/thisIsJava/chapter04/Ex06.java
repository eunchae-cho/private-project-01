// for문을 이용하여 삼각형 찍기

package com.thisIsJava.chapter04;

public class Ex06 {
  public static void main(String[] args) {
    for(int i = 1; i <= 5; i++) {
        for(int j = 1; j <= i; j++) {
          System.out.print("*");
        }
        System.out.println();
    }
  }
}
