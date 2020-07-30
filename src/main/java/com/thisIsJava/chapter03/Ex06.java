package com.thisIsJava.chapter03;

public class Ex06 {
  public static void main(String[] args) {
    int lengthTop = 5;
    int lengthBottom = 10;
    int height = 7;
    double area = ((double)lengthTop + lengthBottom)/2*height;
    System.out.println(area);
  }
}

// 무조건 double로 형변환시켜야 한다.