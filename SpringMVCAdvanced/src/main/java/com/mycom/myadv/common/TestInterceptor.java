package com.mycom.myadv.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	// DispatcherServlet를  이후 다른 Controller의 메소드를 실행하기 직전에 호출
	// 뭔가 test를 진행하고, 그 결과에 따라 return true--> Controller로 진행
	// return false --> Controller로 진행 X --> empty response를 Client에게 보냄
	
	// 테스트 하려는 항목이 뭔가!! => 이곳 코드 안에서 처리/판단
	// 이걸 누구에게 적용할 것인가!! => 설정을 통해서 servlet-context.xml 지정
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		
		System.out.println("TestInterceptor : preHandle !!!");
		
		//#1. 무조건 통과 test
//		return true;
		
		// #2. login test
		HttpSession session=request.getSession();
		String login=(String)session.getAttribute("login");
		// login 상태
		if ("success".equals(login)) return true;
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write("log이 필요합니다");
		return false;
	}
}
