package com.mycom.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.dao.UserDao;
import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired			//field DI --> 요즘에는 생성자 DI 추천 
	UserDao userDao;
	
	private final int SUCCESS=1;
	private final int FAIL=-1;
	
	@Override
	public UserResultDto userRegister(UserDto userDto) {
		UserResultDto userResultDto=new UserResultDto();
		if (userDao.userRegister(userDto)==1) {
			userResultDto.setResult(SUCCESS);
		} else {
			userResultDto.setResult(FAIL);
		}
		
		return userResultDto;
	}
}
