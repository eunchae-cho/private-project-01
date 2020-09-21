package com.io.ex06;
// BufferedInputStream과 BufferedOutputStream을 사용하여 파일 복사 및 시간 측정
public class Exam0320 {
	public static void main(String[] args) throws Exception {
		BufferedInputStream in = new BufferedInputStream("temp/jls11.pdf");
		BufferedOutputStream out = new BufferedOutputStream("temp/jls11_4.pdf");

		int b;
		long startTime = System.currentTimeMillis();

		while ((b = in.read()) != -1) {
			out.write(b);
		}
		out.flush();

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
		in.close();
		out.close();
	}

}
