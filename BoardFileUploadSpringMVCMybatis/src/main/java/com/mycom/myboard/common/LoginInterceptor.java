package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myboard.dto.UserDto;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	// DispatcherServlet를  이후 다른 Controller의 메소드를 실행하기 직전에 호출
	// 뭔가 test를 진행하고, 그 결과에 따라 return true--> Controller로 진행
	// return false --> Controller로 진행 X --> empty response를 Client에게 보냄
	
	// 테스트 하려는 항목이 뭔가!! => 이곳 코드 안에서 처리/판단
	// 이걸 누구에게 적용할 것인가!! => 설정을 통해서 servlet-context.xml 지정
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		
		
		System.out.println("LoginInterceptor : preHandle !!!");
		
		HttpSession session=request.getSession();
		UserDto userDto=(UserDto)session.getAttribute("userDto");
		// login 상태
		if (userDto==null) {
			
			response.sendRedirect("/login");
			return false;	// 미통과 --> 단지 return false만 하면 아무런 반응 X <= response필요
		}
		
		return true;	// 통과 --> Client가 가고자 하는 요청으로 넘어감
	}
}
