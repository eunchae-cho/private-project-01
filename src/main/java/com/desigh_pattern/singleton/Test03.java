package com.desigh_pattern.singleton;

class Kimbap {
	private static Kimbap instance;
	private Kimbap() {}

	public static Kimbap getInstance() {
		if(Kimbap.instance == null) {
			Kimbap.instance = new Kimbap();
		}
		return Kimbap.instance;
	}

}


public class Test03 {
	public static void main(String[] args) {

		//Kimbap bap1 = new Kimbap();

		Kimbap bap2 = Kimbap.getInstance();
		Kimbap bap3 = Kimbap.getInstance();
		System.out.println(bap2 == bap3);
	}
}
