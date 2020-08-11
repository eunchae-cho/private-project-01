package com.thisIsJava.chapter07;

public class StudentExample {
  public static void main(String[] args) {
    Student s = new Student("홍길동","111111-222222",1);
    System.out.println("name: "+s.name);
    System.out.println("ssn: "+s.ssn);
    System.out.println("studentNo: "+s.studentNo);
  }

}
