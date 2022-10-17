package com.mycom.myapp.calc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		//Spring DI
		//Spring 환경 구성 코드 (마치 톰켓처럼)
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("calc-annotation.xml");
		Calculator calculator = (Calculator) context.getBean("calculator"); // 이름 <=default로
		
		System.out.println(calculator.add(5, 7));
	}

}
