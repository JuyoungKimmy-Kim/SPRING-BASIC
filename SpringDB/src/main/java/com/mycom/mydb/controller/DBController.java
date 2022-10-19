package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@Controller
public class DBController {

	@Autowired
	DBService service;
	
	@GetMapping(value="/")
	public String dbTest() {
		System.out.println("DBController /");
		return "/dbTest";
	}
	
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		
		return empDto;
	}
	
	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}
	
	@PostMapping(value="/empInsert")
	@ResponseBody
	public int empInsert(EmpDto dto) {  // Frontend에서 json으로 데이터가 넘어오지 않는다.
		System.out.println(dto);
		int ret = service.empInsert(dto);
		return ret;
	}
	
	@PostMapping(value="/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto dto) {  // Frontend에서 json으로 데이터가 넘어오지 않는다.
		System.out.println(dto);
		int ret = service.empUpdate(dto);
		return ret;
	}
	
	@GetMapping(value="/empDelete/{employeeId}")
	@ResponseBody
	public int empDelete(@PathVariable int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		return ret;
	}
}
