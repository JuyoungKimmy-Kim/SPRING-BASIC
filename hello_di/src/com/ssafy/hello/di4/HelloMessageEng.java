package com.ssafy.hello.di4;

public class HelloMessageEng implements HelloMessage {

	public HelloMessageEng () {
		System.out.println("HelloMessageEng instance");
		init();
	}

	public void init () {
		System.out.println("Initialise Eng instance");
	}
	
	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello "+name;
	}
}
