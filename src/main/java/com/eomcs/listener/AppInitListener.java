package com.eomcs.listener;

import com.eomcs.context.ApplicationContextListener;

public class AppInitListener implements ApplicationContextListener {

	@Override
	public void contextInitialized() {
		System.out.println("환영합니다!");
		System.out.println("프로그램을 시작합니다:)");
	}

	@Override
	public void contextDestoryed() {
		System.out.println("프로그램을 마칩니다!");
		System.out.println("감사합니다:)");
	}
}
