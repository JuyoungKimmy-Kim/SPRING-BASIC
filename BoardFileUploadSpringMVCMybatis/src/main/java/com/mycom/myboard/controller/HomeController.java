package com.mycom.myboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// jsp 3개의 이동에 대한 처리만
@Controller
public class HomeController {
		
	@GetMapping({"/", "/board"})
	public String home() {
		return "/board/boardMain";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/register";
	}
}
