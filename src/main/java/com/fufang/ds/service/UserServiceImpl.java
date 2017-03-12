package com.fufang.ds.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fufang.ds.entity.User;
import com.fufang.ds.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserSerivce {
	
	@Autowired     
	private UserMapper userMapper;
	@Override
	public ArrayList<User> selectAll() {
		org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
		return userMapper.selectAll();
	}

}
