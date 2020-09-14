package com.exception.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0520 {
	static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
		if (i == 0)
			throw new Exception();
		else if (i == 1)
			throw new RuntimeException();
		else if (i == 2)
			throw new SQLException();
		else if (i == 3)
			throw new IOException();
		else if (i < 0)
			throw new Error(); // 시스템 오류가 발생하다고 가정하자!
	}

	public static void main(String[] args) throws Exception {
		try {
			m(1);
			// 여기서 발생된 예외는  try블록에서 받지 않고
			// main() 호출자에게 위임
		} finally {
			System.out.println("마무리 작업 실행");
			// 예외 발생과 상관 없이(catch 없이) 실행됨
		}
	}

}
