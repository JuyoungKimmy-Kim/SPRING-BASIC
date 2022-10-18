package com.mycom.myapp.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess {
	public void bp() {
		// Log code 가 있어야 할 위치... 그러나 aop를 이용해서 log를 남기려고 함
		System.out.println("BusinessProcess : bp() is called!!");
	}

	public void no_bp() {
		System.out.println("BusinessProcess : no_bp() is called!!");
	}

	public int int_bp() {
		System.out.println("BusinessProcess : int_bp() is called!!");
		return 0;
	}

	public int int_String_bp(String s1, int i, String s2) {
		System.out.println("BusinessProcess : int_String_bp() is called!!");
		return 0;
	}
}