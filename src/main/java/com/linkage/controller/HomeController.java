package com.linkage.controller;

import com.linkage.service.AdService;
import com.linkage.service.TopicService;
import com.linkage.service.VideoService;
import com.linkage.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/home")
public class HomeController {
    @Resource
    @Qualifier("AdService")
    private AdService adService;
    @Resource
    @Qualifier("VideoService")
    private VideoService videoService;
    @Resource
    @Qualifier("TopicService")
    private TopicService topicService;
    @GetMapping("home")
    public String  test(){
        return "hello world";
    }

    @GetMapping("index")
    public Object getIndexData(){
        Map<String,Object> res=new HashMap<>();
        res.put("adList",adService.getAllAds());
        res.put("videoList",videoService.getAllVideos());
        res.put("topicList",topicService.getTopics(1));
        return ResponseUtil.ok(res);
    }
}
