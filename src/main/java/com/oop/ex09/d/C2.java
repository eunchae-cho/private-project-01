package com.oop.ex09.d;

// 상위 인터페이스에 있는 메서드 중
// 메서드명과 파라미터 형식은 같지만
// 리턴 타입이 다른 메서드가 있다면
// 둘 중 어떤 것을 상속 받느냐에 따라 규칙이 달라진다.
// 이런 경우 다중 상속 불가능!
public interface C2 extends A, B2{
	void m3();
}
