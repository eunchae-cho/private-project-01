package com.exception.ex03;

public class Exam0212 {

	// 반드시 메서드 선언부에 어떤 예외를 던지는지 지정
	static void m1() throws Exception{
		throw new Exception();
	}

	static void m2() {
		//throw new Exception(); 이런 경우 컴파일 에러!
	}

	//	static void m3() throw String{
	//		throw new Sring();
	//	} 컴파일 오류 - throw로 던질 수 있는 객체는 오직
	// java.lang.Throwable 타입이다

	public static void main(String[] args) {
	}
}
