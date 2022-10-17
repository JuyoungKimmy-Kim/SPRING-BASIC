package com.mycom.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseCalculator {

	// #1. field DI, DI Annotation
//	@Autowired // 이 필드에 Calculator 객체를 만들어 달라
//	Calculator calculator;
	
	// #2. setter DI
	Calculator calculator;
	
//	@Autowired
//	public void setCalculator (Calculator calculator) {
//		this.calculator=calculator;
//	}
	
	// #3. constructor DI
	@Autowired
	public UseCalculator (Calculator calculator) {
		this.calculator=calculator;
	}
	
	
	public int add (int n1, int n2) {
		return calculator.add(n1, n2);
	}
}
