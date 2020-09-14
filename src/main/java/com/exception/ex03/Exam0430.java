package com.exception.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0430 {
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
			m(1);{

			}
		} catch (Exception e) {
			// 처음에 Exception을 하면 이 쪽으로 다 넘어간다.
			// 모든 서브 클래스의 객체도 다 받게 된다.
		} catch (IOException e) {
		} catch (SQLException e) {
		} catcch (RuntimeException e){
		}
	}
}
