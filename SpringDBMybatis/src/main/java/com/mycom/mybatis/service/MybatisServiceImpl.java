package com.mycom.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.MybatisDao;
import com.mycom.mybatis.dto.EmpDto;

@Service
public class MybatisServiceImpl implements MybatisService {

	@Autowired
	MybatisDao dao;

	@Override
	public EmpDto empDetail(int employeeId) {
		return dao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		return dao.empList();
	}

	@Override
	public int empInsert(EmpDto empDto) {
		return dao.empInsert(empDto);
	}

	@Override
	public int empUpdate(EmpDto empDto) {
		return dao.empUpdate(empDto);
	}

	@Override
	public int empDelete(int employeeId) {
		return dao.empDelete(employeeId);
	}	
}
