package com.fufang.bi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fufang.bi.entity.MyReward;
import com.fufang.bi.mapper.MyRewardMapper;

@Service
public class MyRewordServiceImpl  implements MyRewordService{

	@Autowired
	private MyRewardMapper  myRewardMapper;
	@Override
	public ArrayList<MyReward> selectAll() {
		return myRewardMapper.selectAll();
	}

}
