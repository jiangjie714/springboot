package com.fufang.ds.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import com.fufang.ds.entity.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    ArrayList<User> selectAll();
}