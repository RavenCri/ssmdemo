package com.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pojo.User;

@Mapper //mapper注解
public interface UserLoginMapper {
	public User userLogin(User user);
}
