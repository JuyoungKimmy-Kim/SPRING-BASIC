package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto empDto);
	int empUpdate(EmpDto empDto);
	int empDelete(int employeeId);
}
