package com.chapter03;

public class Ex03 {
  public static void main(String[] args) {
    int score = 85;
    
    String result = (!(score>90)) ? "가" : "나";
    System.out.println(result);
    
    result = (score>90) ? "가" : "나";
    System.out.println(result);
  }
}
