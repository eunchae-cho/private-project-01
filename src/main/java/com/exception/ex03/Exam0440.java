package com.exception.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0440 {
	static void m(int i) throws Exception, RuntimeException, SQLException, IOException{
		if (i == 0)
			throw new Exception();
		else if (i == 1)
			throw new RuntimeException();
		else if (i == 2)
			throw new SQLException();
		else if (i == 3)
			throw new IOException();
	}

	public static void main(String[] args) {
		try {
			m(1);
		} catch (Exception e) {
			// RuntimeException, SQLException, IOException 다 받음
			// Exception의 서브클래스이기 때문
		}
	}
}
