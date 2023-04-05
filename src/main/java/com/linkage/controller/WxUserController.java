package com.linkage.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.linkage.dto.UserInfoDto;
import com.linkage.dto.WxLoginInfo;
import com.linkage.pojo.User;
import com.linkage.service.UserService;
import com.linkage.utils.IpUtil;
import com.linkage.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/wx/user")
public class WxUserController {
    @Resource
    @Qualifier("UserService")
    private UserService userService;
    @Resource
    private WxMaService wxService;
    @PostMapping("login_by_weixin")
    public Object loginByWeiXin(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request){
        String code = wxLoginInfo.getCode();
        UserInfoDto userInfo = wxLoginInfo.getUserInfo();
        if(code==null||userInfo==null){
            return ResponseUtil.badArgument();
        }
        String sessionKey = null;
        String openId = null;
        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sessionKey == null || openId == null) {
            return ResponseUtil.fail();
        }
        User user = userService.queryByOpenId(openId);
        if(user == null){
            user = new User();
            user.setUsername(openId);
            user.setPassword(openId);
            user.setWeixinOpenid(openId);
            user.setAvatar(userInfo.getAvatarUrl());
            user.setNickname(userInfo.getNickName());
            user.setGender(userInfo.getGender());
            user.setUserLevel((byte) 0);
            user.setStatus((byte) 0);
            user.setLastLoginTime(LocalDateTime.now());
            user.setLastLoginIp(IpUtil.getIpAddr(request));
            user.setSessionKey(sessionKey);
            userService.addUser(user);
        }else{
            user.setLastLoginTime(LocalDateTime.now());
            user.setLastLoginIp(IpUtil.getIpAddr(request));
            user.setSessionKey(sessionKey);
            if (userService.updateById(user) == 0) {
                return ResponseUtil.updatedDataFailed();
            }
        }
        Map<String,Object> res=new HashMap<>();
        res.put("userInfo",userInfo);
        res.put("skey",openId);
        return ResponseUtil.ok(res);
    }

}
