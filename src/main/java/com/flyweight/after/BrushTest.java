package com.flyweight.after;

import java.util.Scanner;

public class BrushTest {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);
		BrushPool brushPool = new BrushPool();

		while (true) {
			System.out.print("패턴? ");
			String pattern = keyScan.nextLine();

			System.out.print("선 길이? ");
			int length = keyScan.nextInt();
			if (length < 0) {
				break;
			}

			Brush brush = brushPool.getBrush(pattern);
			brush.draw(length);
		}

		keyScan.close();
	}
}
