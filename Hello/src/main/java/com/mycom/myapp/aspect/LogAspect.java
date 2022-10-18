package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//     Spring 에서 내부적으로 관리되어야 하는 컴포넌트
@Component
// aop 를 처리하는 특별한 컴포넌트
@Aspect
public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// BusinessProcess 의 method 에 끼어들려고 한다. (Aspect)

	// PointCut 으로 끼어들 method 를 선택
	// PointCut 은 메소드 signature 를 이용

//	@Pointcut(value = "execution( int com.mycom.myapp.aspect.*.*(..) )") // return type - package - class - method(
//																		// parameter )
//	private void logPointCut() {
//	} // 어느 클래스의 어느 메소드에 끼어드는지 표현
//
//	// Advise 를 이용해서 앞, 뒤 등 메소드 호출별 시점을 지정
//	@Before("logPointCut()")
//	public void beforeLog(JoinPoint joinPoint) { // joinPoint 끼어드는 메소드의 연결 정보
//		Signature signature = joinPoint.getSignature();
//		System.out.println("[sysout : Before] 메소드 이름 : " + signature.getName()); // 단순 출력
//		logger.debug("Logger : Before] 메소드 이름 : " + signature.getName()); // 메세지를 logger를 통해서 debug level 로 출력
//	}
//	
//	@After("logPointCut()")
//	public void afterLog(JoinPoint joinPoint) { // joinPoint 끼어드는 메소드의 연결 정보
//		Signature signature = joinPoint.getSignature();
//		System.out.println("[sysout : After] 메소드 이름 : " + signature.getName()); // 단순 출력
//		logger.debug("Logger : After] 메소드 이름 : " + signature.getName()); // 메세지를 logger를 통해서 debug level 로 출력
//	}
	
	@Pointcut(value = "execution( int com.mycom.myapp.aspect.*.*(String, int, String) )") // return type - package - class - method(
	private void logPointCut2 () {}
	@Before("logPointCut2()")
	public void beforeLog2(JoinPoint joinPoint) { // joinPoint 끼어드는 메소드의 연결 정보
		Signature signature = joinPoint.getSignature();
		System.out.println("[sysout : Before] 메소드 이름 : " + signature.getName()); // 단순 출력
		logger.debug("Logger : Before] 메소드 이름 : " + signature.getName()); // 메세지를 logger를 통해서 debug level 로 출력
	}
}