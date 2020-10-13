package com.observer.test;

import java.util.ArrayList;
import java.util.List;

public class Car {

	List<CarObserver> observers = new ArrayList<>();

	public void addCarObserver(CarObserver observer) {
		observers.add(observer);
	}

	public void removeCarObserver(CarObserver observer) {
		observers.remove(observer);
	}

	private void notifyCarObserverOnStart() {
		for (CarObserver observer : observers) {
			observer.carStarted();
		}
	}

	private void notifyCarObserverOnStop() {
		for (CarObserver observer : observers) {
			observer.carStopped();
		}
	}

	public void start() {
		System.out.println("시동을 켠다.");
		notifyCarObserverOnStart();
	}

	public void run() {
		System.out.println("달린다.");
	}

	public void stop() {
		System.out.println("시동을 끈다.");
		notifyCarObserverOnStop();
	}
}
