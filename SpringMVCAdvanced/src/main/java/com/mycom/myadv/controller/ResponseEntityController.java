package com.mycom.myadv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;

// rest api를 이용하는 과정에서 특히 많이 활용하는 방법
// HTTP Status Code 200 : 성공, 404 : Not Found, 500 : Internal Server Error....
// HTTP request 를 보내고 그 결과를  http response로 받는 과정에서
// business logic상의 성공, 실패, 또는 또다른 어떤 결과를 front-end와 back-end 사이에서 주고받아야 한다면
// 차라리 그 부분을 위 Http Status Code를 이용하면 어떨까 ? 하는 생각

@RestController // --> @RestController = @Controller + 모든 메소드 위에 @ResponseBody
public class ResponseEntityController {
	
//	@GetMapping(value="/students")
//	@ResponseBody
//	public List<StudentDto> list() {
//		List<StudentDto> list=new ArrayList<>();
//		// service <-> dao 이후
//		list.add(new StudentDto (111, "홍길동", "hong@gildong.com", "010-1111-1111"));
//		list.add(new StudentDto (222, "이길동", "lee@gildong.com", "010-2222-2222"));
//		list.add(new StudentDto (333, "삼길동", "sam@gildong.com", "010-3333-3333"));
//		
//		return list;
//	}
	
	
	@GetMapping(value="/students")
//	@ResponseBody
	public ResponseEntity<List<StudentDto>> list() {
		List<StudentDto> list=new ArrayList<>();
		// service <-> dao 이후
		list.add(new StudentDto (111, "홍길동", "hong@gildong.com", "010-1111-1111"));
		list.add(new StudentDto (222, "이길동", "lee@gildong.com", "010-2222-2222"));
		list.add(new StudentDto (333, "삼길동", "sam@gildong.com", "010-3333-3333"));
		
		// #1. 올바른 처리가 된다면 -> list 출력
		//return ResponseEntity.ok().body(list);
		
		// #2. 목록을 처리하려고 했는데 결과가 없다
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value="/students/{studentId}")
//	@ResponseBody
	public ResponseEntity<StudentDto> detail(@PathVariable int studentId) {
		
		//service <-> dao 이후
		StudentDto dto=new StudentDto (111, "홍길동", "hong@gildong.com", "010-1111-1111");
		//return new ResponseEntity<StudentDto> (dto, HttpStatus.OK);
		//return new ResponseEntity<StudentDto> (dto, HttpStatus.NOT_FOUND);
		return new ResponseEntity<StudentDto> (dto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// Rest Api의 기본적인 IDEA  --> insertStudent(X), studentInsert(X)
	// 학생 => students 
	// url mapping을
	// 등록 	  /students + POST
	// 수정 	  /students/{studentId} + PUT
	// 삭제	  /students/{studentId} + DELETE
	// 목록 조회  /students + GET
	// 상세 조회  /students/{studentId} + GET
}
