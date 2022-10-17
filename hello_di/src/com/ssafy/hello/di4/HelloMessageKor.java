package com.ssafy.hello.di4;

public class HelloMessageKor implements HelloMessage{

	public HelloMessageKor () {
		System.out.println("HelloMessageKor instance");
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "안녕" + name;
	}
}
