package com.mycom.mybatis.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto empDto);
	int empUpdate(EmpDto empDto);
	int empDelete(int employeeId);
	
	List<EmpDto> empListParameterMap(Map<String, String> map);
	List<EmpDto> empListParameterMap2(String firstName, String lastName);
	List<EmpDto> empListParameterMap3(EmpDto dto);
	List<EmpDto> empListLike(String firstName);

}
