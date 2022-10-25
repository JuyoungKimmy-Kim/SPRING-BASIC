package com.mycom.myboard.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycom.myboard.dto.BoardResultDto;

@ControllerAdvice	// 개별 컴포넌트에서 처리되지 않은 예외를 처리
public class GlobalExceptionHandler {
	
	@ExceptionHandler (Exception.class)	//모든 예외 처리를 할 것
	public ResponseEntity<BoardResultDto> handleErrorResponseEntity(Exception e) {
		e.printStackTrace();
		// 에러 JSP에 대한 분기 처리가 아니라
		// 주된 요청이 비동기이기 때문에 json으로 결과(-1)를 리턴하는 형태로 작성
		
		System.out.println("Global Exception Handler!");
		BoardResultDto boardResultDto=new BoardResultDto();
		boardResultDto.setResult(-1); // 1: 성공, -1: 실패
		
		return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
