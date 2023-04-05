package com.linkage.mapper;

import com.linkage.dto.TopicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicMapper {
    List<TopicDto> getAllTopics(@Param("type")int type);
    String getTopicNameByTopicID(@Param("topicID")Integer topicID);

}
