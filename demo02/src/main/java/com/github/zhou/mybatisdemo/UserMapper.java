package com.github.zhou.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserBySchoolName(User user);
}
