package com.exerciseAlgorithm.euler;
//
//피보나치(Fibonacci) 수열의 각 항은 바로 앞의 항 두 개를 더한 것입니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.
//
//1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//4백만 이하의 짝수 값을 갖는 모든 피보나치 항을 더하면 얼마가 됩니까?

public class Ex02 {
	public static void main(String[] args) {
		int[] arr = new int[4_000_000];
		int num = 4_000_000;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				arr[i - 1] = i;
				for(int j = 0; j < arr.length; j++) {
					arr[j] = arr[i - 1] + arr[i]; 
					System.out.println(arr[j]);
				}
			}
		}
	}
}
