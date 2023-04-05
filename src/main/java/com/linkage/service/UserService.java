package com.linkage.service;

import com.linkage.pojo.User;

public interface UserService {
    void addUser(User user);
    User queryByOpenId(String openId);
    int updateById(User user);
}
