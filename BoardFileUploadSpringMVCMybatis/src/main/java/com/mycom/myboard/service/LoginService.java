package com.mycom.myboard.service;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;

public interface LoginService {
	UserDto login (UserDto dto);	// 회원 가입의 성공, 실패 여부

}
