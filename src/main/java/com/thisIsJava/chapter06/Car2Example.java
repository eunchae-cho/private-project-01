package com.thisIsJava.chapter06;

public class Car2Example {
  public static void main(String[] args) {

    Car2 c1 = new Car2();
    System.out.println("c1.company: "+c1.company);
    System.out.println();

    Car2 c2 = new Car2("자가용");
    System.out.println("c2.company: "+c2.company);
    System.out.println("c2.model: "+c2.model);
    System.out.println();

    Car2 c3 = new Car2("자가용", "빨강");
    System.out.println("c3.company: "+c3.company);
    System.out.println("c3.model: "+c3.model);
    System.out.println("c3.color: "+c3.color);
    System.out.println();

    Car2 c4 = new Car2("자가용", "빨강", 200);
    System.out.println("c4.company: "+c4.company);
    System.out.println("c4.model: "+c4.model);
    System.out.println("c4.color: "+c4.color);
    System.out.println("c4.maxSpeed: "+c4.maxSpeed);
    System.out.println();
  }
}
