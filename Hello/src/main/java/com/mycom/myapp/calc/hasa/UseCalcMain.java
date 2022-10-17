package com.mycom.myapp.calc.hasa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCalcMain {

	public static void main(String[] args) {
		//Spring DI
		//Spring 환경 구성 코드 (마치 톰켓처럼)
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("use-calc-annotation.xml");
		UseCalculator useCalculator = (UseCalculator) context.getBean("useCalculator"); // 이름 <=default로
		
		System.out.println(useCalculator.add(5, 7));
	}

}
