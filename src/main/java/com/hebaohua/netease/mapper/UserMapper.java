package com.hebaohua.netease.mapper;


import com.hebaohua.netease.entity.User;

public interface UserMapper {
    User getUserByName(String userName);
}