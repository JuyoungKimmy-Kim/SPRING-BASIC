package com.ssafy.hello.di1;

public class HelloMain {

	public static void main(String[] args) {
		HelloMessageKor kor=new HelloMessageKor();
		String greet=kor.helloKor("김주영");
		System.out.println(greet);
	}

}
