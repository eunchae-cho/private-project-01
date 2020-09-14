package com.exception.ex03;

import java.io.FileNotFoundException;

public class Exam0210 {
	// throw 명령어를 사용하여 예외 정보를 호출자에게 던진다.
	// throw [java.lang.Throwable 타입의 객체]

	// java.lang.Throwable
	// 1) java.lang.Error (시스템 오류) - JVM이 발생된 오류
	// 2) java.lang.Exception (애플리케이션 오류) - 개발자가 사용하는 클래스

	static void m1() throws Throwable {
		throw new Throwable();
		// 직접 d이렇게 사용하지 않는다. 하위 클래스 사용
	}

	static void m2() throws FileNotFoundException, RuntimeException{
		int a = 100;
		if (a < 0) 
			throw new FileNotFoundException();
		else
			throw new RuntimeException();
	}
	public static void main(String[] args) {

	}
}
