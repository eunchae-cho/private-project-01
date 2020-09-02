package com.pms.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
	static Scanner sc = new Scanner(System.in);
	
	public static String inputString(String titel) {
		System.out.print(titel);
		return sc.nextLine();
	}
	
	public static int inputInt(String titel) {
		return Integer.parseInt(inputString(titel));
	}
	
	public static Date inputDate(String titel) {
		return Date.valueOf(inputString(titel));
	}
	
	public static void close() {
		sc.close();
	}
}
