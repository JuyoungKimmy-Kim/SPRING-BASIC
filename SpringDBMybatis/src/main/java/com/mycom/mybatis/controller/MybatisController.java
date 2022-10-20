package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MybatisService;

@Controller
public class MybatisController {
	
	@Autowired
	MybatisService service;
	
	@GetMapping(value="/")
	public String viewTest() {
		System.out.println("DBController / ");
		return "dbTest";
	}
	
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {		
		System.out.println(employeeId);
		EmpDto dto = service.empDetail(employeeId);
		return dto;
	}
	
	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> empList(){
		List<EmpDto> empList = service.empList();
		return empList;
	}
	
	@PostMapping(value="/empInsert")
	@ResponseBody
	public int empInsert(EmpDto empDto) {		// FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(empDto);		
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	@PostMapping(value="/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto empDto) {		// FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(empDto);		
		int ret = service.empUpdate(empDto);
		return ret;
	}
	
	@PostMapping("/empDelete")
	@ResponseBody
	public int empDelete(int employeeId) {		// FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(employeeId);		
		int ret = service.empDelete(employeeId);
		return ret;
	}
}
