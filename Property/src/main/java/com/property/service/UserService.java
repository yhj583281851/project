package com.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.bean.User;
import com.property.bean.UserExample;
import com.property.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	/***
	 * 查询所有用户
	 */
	public List<User> selectOnePageUser() {
		return userMapper.selectByExample(new UserExample());
	}

}
