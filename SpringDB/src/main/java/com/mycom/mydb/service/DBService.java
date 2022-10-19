package com.mycom.mydb.service;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBService {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empUpdate(EmpDto dto);
	public int empDelete(int employeeId);
}
