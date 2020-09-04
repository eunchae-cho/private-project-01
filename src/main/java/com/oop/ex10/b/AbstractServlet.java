package com.oop.ex10.b;

// 추상 클래스를 이용하여 인터페이스 구현
public abstract class AbstractServlet {

	public void init() {}
	public void destory() {}
	public String getServletInfo() {
		return null;
	}
	public String getServletConfig() {
		return null;
	}
}
