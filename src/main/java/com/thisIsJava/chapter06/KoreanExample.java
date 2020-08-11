package com.thisIsJava.chapter06;

public class KoreanExample {
  public static void main(String[] args) {

    Korean kr1 = new Korean("박자바", "010101-121212");
    System.out.printf("이름: %s\n주민번호: %s\n",kr1.name,kr1.ssn);

    Korean kr2 = new Korean("김자바", "111222-222000");
    System.out.printf("이름: %s\n주민번호: %s\n",kr2.name,kr2.ssn);
  }
}
