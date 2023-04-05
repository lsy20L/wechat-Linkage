package com.linkage.controller;

import com.linkage.service.TopicService;
import com.linkage.utils.ResponseUtil;
import com.linkage.vo.TopicVo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/topic")
public class TopicController {
    @Resource
    @Qualifier("TopicService")
    TopicService topicService;
    @GetMapping("/name")
    public Object name(Integer typeID) {
        List<TopicVo> topics = topicService.getTopics(typeID);
        List<String> topicNames = new ArrayList<>();
        topics.forEach(topicVo -> topicNames.add(topicVo.getTopicName()));
        Map<String, Object> res = new HashMap<>();
        res.put("topics",topicNames);
        return ResponseUtil.ok(res);
    }
}
