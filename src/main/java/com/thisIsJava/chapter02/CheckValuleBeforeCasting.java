package com.thisIsJava.chapter02;
// 변환으로 인한 데이터 손실이 발생되지 않도록 한다.

public class CheckValuleBeforeCasting {
  public static void main(String[] args) {
   
      int i = 128;
      
      if (i > Byte.MAX_VALUE || i < Byte.MIN_VALUE) {
        System.out.println("byte타입으로 변환할 수 없습니다.");
      } else {
        byte b = (byte)i;
        System.out.println(b);
      }
    }
  
}
