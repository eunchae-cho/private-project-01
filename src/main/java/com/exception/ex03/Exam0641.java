package com.exception.ex03;

public class Exam0641 {

	static class B implements AutoCloseable {

		public void m(int value) throws Exception {

			if (value < 0) {
				throw new Exception("음수입니다.");
			}
			System.out.println("m() 호출");
		}

		@Override
		public void close() throws Exception {
			System.out.println("B 클래스의 자원을 해제하였습니다.");
			// catch가 실행되기 전 실행됨 
		}
	}

	public static void main(String[] args) throws Exception {
		try( B obj = new B()) {
			System.out.println("try 블록 시작");
			obj.m(-100);

			System.out.println("try 블록 종료");
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
	}

}
