package com.mycom.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.dao.LoginDao;
import com.mycom.myboard.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDto login(UserDto dto) {
		//dto : client가 전송한 것
		//userDto : db에서 가져온 것
		
		UserDto userDto=loginDao.login(dto.getUserEmail());
		if (userDto!=null && userDto.getUserPassword().equals(dto.getUserPassword())) {
			return userDto;
		} 
		return null;
	}

}
