package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto empDto);
	int empUpdate(EmpDto empDto);
	int empDelete(int employeeId);
}
