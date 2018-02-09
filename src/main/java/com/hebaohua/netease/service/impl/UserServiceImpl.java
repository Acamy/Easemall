package com.hebaohua.netease.service.impl;

import com.hebaohua.netease.entity.User;
import com.hebaohua.netease.mapper.UserMapper;
import com.hebaohua.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByName(String userName) throws Exception {
		User user = userMapper.getUserByName(userName);
		return user;
	}
}
