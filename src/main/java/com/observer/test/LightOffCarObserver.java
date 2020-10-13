package com.observer.test;

public class LightOffCarObserver extends AbstractCarObserver {

	@Override
	public void carStopped() {
		System.out.println("전조등 꺼짐");
	}
}
