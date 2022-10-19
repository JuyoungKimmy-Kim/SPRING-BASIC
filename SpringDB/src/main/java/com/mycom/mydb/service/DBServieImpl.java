package com.mycom.mydb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mydb.dao.DBDao;
import com.mycom.mydb.dto.EmpDto;

@Service
public class DBServieImpl implements DBService{
	@Autowired
	DBDao dao;

	@Override
	public EmpDto empDetail(int employeeId) {
		return dao.empDetail(employeeId);
	}
}
