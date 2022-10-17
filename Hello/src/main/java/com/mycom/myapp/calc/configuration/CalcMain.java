package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {

	public static void main(String[] args) {

		// 자바 (Configuration 클래스를 이용)

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		Calculator calculator = (Calculator) context.getBean("calculator"); // id로 지정된 값

		System.out.println(calculator.add(5, 7));
	}

}
