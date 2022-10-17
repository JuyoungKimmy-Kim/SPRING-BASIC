package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// xml configuration에서 bean 설정을 java code로 표현
// 표현 방법은 annotation

@Configuration // <= Spring이 인식하는 설정 클래스
public class CalcConfiguration {
	
	@Bean
	public Calculator calculator () {
		return new Calculator();
	}
}
