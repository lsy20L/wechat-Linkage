package com.linkage.utils;

import com.linkage.dto.TextDto;
import com.linkage.dto.TopicDto;
import com.linkage.dto.VideoDto;
import com.linkage.vo.TextVo;
import com.linkage.vo.TopicVo;
import com.linkage.vo.VideoVo;

public class FactoryUtil {
    public static TextVo createByTextDto(TextDto textDto){
        return new TextVo(textDto.getAvatarUrl(),
                textDto.getNickName(),
                textDto.getTextName(),
                textDto.getTextContent(),
                textDto.getTextImageUrl().split(","),
                textDto.getTopicName(),
                textDto.getTextLoveNumber(),
                textDto.getTextContactType(),
                textDto.getTextContactNumber(),
                textDto.getTextID());
    }
    public static TopicVo createByTopicDto(TopicDto topicDto){
        return new TopicVo(topicDto.getTopicID(),topicDto.getTopicName(),topicDto.getTopicImageUrl());
    }
    public static VideoVo createByVideoDto(VideoDto videoDto){
        return new VideoVo(videoDto.getNickName(),
                videoDto.getNickName(),
                videoDto.getVideoName(),
                videoDto.getVideoUrl(),
                videoDto.getVideoImageUrl(),
                videoDto.getVideoIntroduction(),
                videoDto.getVideoLoveNumber(),
                videoDto.getVideoDuration(),
                videoDto.getVideoID());
    }


}
