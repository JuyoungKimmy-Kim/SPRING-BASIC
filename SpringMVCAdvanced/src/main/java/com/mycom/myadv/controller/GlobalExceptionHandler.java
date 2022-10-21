package com.mycom.myadv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//개별 Controller에서 처리되지 않은 예외에 대한 처리
@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler
//	public ModelAndView errorHandler (HttpServletRequest req, Exception e) {
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", req.getRequestURI());
//		mav.setViewName("globalError");
//		
//		return mav;
//	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> errorHandler (HttpServletRequest req, Exception e) {
		Map<String, String> map=new HashMap<>();
		map.put("reuslt", "ajax_exception");
		return new ResponseEntity<Map<String, String>> (map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
