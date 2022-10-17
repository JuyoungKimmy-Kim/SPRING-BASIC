package com.mycom.myapp.calc.all;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;

public class AllCalculator {
	Calculator calculator;
	
	@Autowired
	@Qualifier("aaa")
	public int add(int n1, int n2) {
		return calculator.add(n1,n2);
	}
}
