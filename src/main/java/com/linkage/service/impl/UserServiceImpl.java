package com.linkage.service.impl;

import com.linkage.mapper.UserMapper;
import com.linkage.pojo.User;
import com.linkage.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public void addUser(User user) {
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.addUser(user);
    }
    @Override
    public User queryByOpenId(String openId) {
        return userMapper.queryByOpenId(openId);
    }
    @Override
    public int updateById(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateById(user);
    }


}
