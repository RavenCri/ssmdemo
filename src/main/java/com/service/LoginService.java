package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.UserLogin;
import com.mapper.UserLoginMapper;
import com.pojo.User;
@Service
public class LoginService {
	@Autowired
	UserLoginMapper userLoginMapper;
	public boolean userLogin(User user){
		User selectUser = userLoginMapper.userLogin(user);
		if(selectUser==null) {
			return false;
		}
		return true;
	}
}
