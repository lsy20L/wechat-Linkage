package com.linkage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final Boolean IS_DELETED = Boolean.valueOf("1");
    public static final Boolean NOT_DELETED = Boolean.valueOf("0");
    private Integer id;
    private String username;
    private String password;
    private Byte gender;
    private LocalDate birthday;
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private Byte userLevel;
    private String nickname;
    private String mobile;
    private String avatar;
    private String weixinOpenid;
    private String sessionKey;
    private Byte status;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean deleted;

}
