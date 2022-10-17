package com.ssafy.hello.di2;

public class HelloMain {

	public static void main(String[] args) {
		HelloMessageKor hello=new HelloMessageKor();
		String greet=hello.hello("김주영");
		System.out.println(greet);
	}

}
