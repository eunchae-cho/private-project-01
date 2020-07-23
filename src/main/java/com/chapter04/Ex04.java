// while문과 Math.random()을 사용해서
// 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1,눈2)로 출력하고
// 눈의 합이 5가 되면 계속 주사위를 던지고 아니면 실행 멈추기

package com.chapter04;

public class Ex04 {
  public static void main(String[] args) {
    
    while(true) {
      int num1 = (int)(Math.random()*6) + 1;
      int num2 = (int)(Math.random()*6) + 1;
      if(num1 + num2 == 5) {
        System.out.printf("(%d,%d)\n",num1,num2);
        break;
      }else {
        System.out.printf("(%d,%d)\n",num1,num2);
      }
    }
  }

}
