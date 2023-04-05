package com.linkage.service;

import com.linkage.vo.TopicVo;

import java.util.List;

public interface TopicService {
    List<TopicVo> getTopics(Integer type);
    String getTopicNameByTopicID(Integer topicID);
}
