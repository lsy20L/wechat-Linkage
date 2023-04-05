package com.linkage.service.impl;

import com.linkage.dto.TopicDto;
import com.linkage.mapper.TopicMapper;
import com.linkage.service.TopicService;
import com.linkage.utils.FactoryUtil;
import com.linkage.vo.TopicVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("TopicService")
public class TopicServiceImpl implements TopicService {
    @Resource
    TopicMapper topicMapper;
    @Override
    public List<TopicVo> getTopics(Integer type) {
        List<TopicDto> allTopics = topicMapper.getAllTopics(type);
        List<TopicVo> topicVos = new ArrayList<>();
        allTopics.forEach(topicDto -> topicVos.add(FactoryUtil.createByTopicDto(topicDto)));
        return topicVos;
    }

    @Override
    public String getTopicNameByTopicID(Integer topicID) {
        return topicMapper.getTopicNameByTopicID(topicID);
    }
}
