package com.thisIsJava.chapter05;
// 다차원 배열

public class ArrayInArrayExample {
  public static void main(String[] args) {
    
    
    // 일반 방법
    int[][] arr = new int[2][3];

    int k = 10;
    for (int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        arr[i][j] = k;
        k += 10;
        
      }
    }
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
        
      }
      System.out.println();
    }
    
    System.out.println("========");
    
    
    
    //초기화 방법
    int[][] arr2 = {{10, 20, 30}, {40, 50, 60}};
    
    for(int i = 0; i < arr2.length; i++) {
      for(int j = 0; j < arr2[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    
    
  }
}
