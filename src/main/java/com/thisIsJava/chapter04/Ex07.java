// while문과 Scanner를 이용해서 예금,출금,조회,종료 기능을 제공


package com.thisIsJava.chapter04;

import java.util.Scanner;

public class Ex07 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean run = true;
    int balance = 0;
    
    while(run) {
      System.out.println("-----------------------------------");
      System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
      System.out.println("-----------------------------------");
      System.out.print("\n선택> ");
      int choice = scanner.nextInt();
      int money = 0;
      
      switch(choice) {
        case 1 :
          System.out.print("예금액> ");
          money = scanner.nextInt();
          balance += money;
          System.out.println();
          break;
        case 2 :
          System.out.print("출금액> ");
          money = scanner.nextInt();
          balance -= money;
          System.out.println();
          break;
        case 3 :
          System.out.println("잔액> "+balance);
          System.out.println();
          break;
        case 4 :
          run = false;
          break;
      }
      
      /*
      if(choice == 1) {
        System.out.print("예금액> ");
        balance = scanner.nextInt();
      }else if(choice == 2) {
        System.out.print("출금액> ");
        money = scanner.nextInt();
      }else if(choice == 3) {
        int rest = balance - money;
        System.out.print("잔고> "+rest);
      }else if(choice == 4) {
        break;
      }else {
        System.out.println("잘못 입력하셨습니다.");
      }
      */
      
    }
    System.out.println("\n프로그램 종료");
  }
}
