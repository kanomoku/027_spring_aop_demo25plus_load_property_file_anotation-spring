package com.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.mapper.UsersMapper;
import com.pojo.Users;
import com.service.UsersService;

public class UsersServiceImpl implements UsersService {

	private UsersMapper usersMapper;
	@Value("${key}")
	private String str;

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Users login(Users users) {
		System.out.println(str);
		return usersMapper.selByUsersPwd(users);
	}

}
