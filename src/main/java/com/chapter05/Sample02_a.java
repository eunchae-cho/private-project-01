package com.chapter05;
// 향상된 for문 ( : ) II
public class Sample02_a {
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

