package com.mycom.myadv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 무조건 json response
public class InterceptorController {
	
	@GetMapping("/login") // login page 이동 효과
	public String m1() {
		System.out.println("/login");
		return "/login";	//jsp로 분기 x 그냥 문자열 그대로 json으로 response
	}
	
	@GetMapping("/login/ok") // login 성공 효과
	public String m2(HttpSession session) {
		System.out.println("/login/ok");
		session.setAttribute("login", "success");
		return "/login/ok";
	}
	
	@GetMapping("/logout") // logout 효과
	public String m3(HttpSession session) {
		System.out.println("/login/ok");
		session.invalidate();
		return "/logout";
	}
	
	@GetMapping("/users") 	// 일반 로그인 성공 후 
	public String m4() {
		System.out.println("/users");
		return "/users";
	}
}
