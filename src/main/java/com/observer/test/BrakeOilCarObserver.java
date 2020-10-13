package com.observer.test;

public class BrakeOilCarObserver extends AbstractCarObserver {

	@Override
	public void carStarted() {
		System.out.println("브레이크 오일 검사 유무");
	}



}
