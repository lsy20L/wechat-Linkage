package com.linkage.mapper;

import com.linkage.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User queryByOpenId(@Param("openID") String openID);
    int updateById(User user);
    void addUser(User user);
}
