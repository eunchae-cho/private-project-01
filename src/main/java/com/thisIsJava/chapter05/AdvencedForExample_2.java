package com.thisIsJava.chapter05;
// 향상된 for문 ( : ) II
public class AdvencedForExample_2 {
  public static void main(String[] args) {
    
    int[] scores = { 95, 71, 84, 93, 87 };
    
    int sum = 0;
    
    for(int i = 0; i < scores.length; i++) {
      sum += scores[i];
      
    }
    System.out.println("점수 총합 = "+sum);
    
    int avg = sum/scores.length;
    System.out.println("점수 평균 = "+avg);
        
    }
  }

