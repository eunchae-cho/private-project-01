package com.eomcs.listener;

import java.util.Map;

import com.eomcs.context.AppContextListener;

public class AppInitListener implements AppContextListener {

	@Override
	public void contextInitialized(Map<String,Object> context) {
		System.out.println("환영합니다!");
		System.out.println("프로그램을 시작합니다:)");
	}

	@Override
	public void contextDestoryed(Map<String, Object> context) {
		System.out.println("프로그램을 마칩니다!");
		System.out.println("감사합니다:)");
	}
}
