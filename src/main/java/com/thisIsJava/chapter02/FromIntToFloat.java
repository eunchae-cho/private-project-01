package com.thisIsJava.chapter02;
// 정수 타입을 실수 타입으로 변환할 때 정밀도 손실을 피한다.

public class FromIntToFloat {
  public static void main(String[] args) {
    int i1 = 123456780;
    int i2 = 123456780;
    
    float f = i2;
    i2 = (int)f;
    
    int result = i1 - i2;
    System.out.println("i1 = "+i1);
    System.out.println("i2 = "+i2);
    System.out.println("결과: "+result);
  }
}
