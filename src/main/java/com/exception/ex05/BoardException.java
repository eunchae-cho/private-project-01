package com.exception.ex05;

public class BoardException extends RuntimeException {

	public BoardException() {
		super();
	}

	public BoardException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public BoardException(String message, Throwable cause) {
		super(message,cause);
	}

	public BoardException(String message) {
		super(message);
	}

	public BoardException(Throwable cause) {
		super(cause);
	}

	// 이 클래스는 생성자가 호출될 때 그와 대응하는 수퍼 클래스의 생성자를 호출하는 일
	// 이외에는 다른 작업을 수행하지 않는다.
	// 상속받은 기능 확장의 목적이 아니라
	// 의미있는 이름을 가진 예외 클래스를 만드는 것이 목적이다.
}
