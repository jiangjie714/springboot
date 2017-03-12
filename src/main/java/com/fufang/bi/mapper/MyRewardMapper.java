package com.fufang.bi.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.fufang.bi.entity.MyReward;

@Mapper
public interface MyRewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyReward record);

    int insertSelective(MyReward record);

    MyReward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyReward record);

    int updateByPrimaryKey(MyReward record);
    
    ArrayList<MyReward> selectAll();
}