package com.observer.test;

public class SunroofCloseCarObserver extends AbstractCarObserver {
	@Override
	public void carStarted() {
		System.out.println("선 루프 닫음");
	}

}
