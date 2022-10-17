package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
	
		System.out.println("Start Program");
		ApplicationContext context=new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
		
		System.out.println("Read XML");
		
		HelloMessage hello=(HelloMessage) context.getBean("eng");
		String greet=hello.hello("김주영");
		System.out.println(greet);
		
		HelloMessage hello2=(HelloMessage) context.getBean("eng");
		HelloMessage hello3=(HelloMessage) context.getBean("eng");
		
		System.out.println(hello+" "+hello2+" "+hello3);
		
	}

}
