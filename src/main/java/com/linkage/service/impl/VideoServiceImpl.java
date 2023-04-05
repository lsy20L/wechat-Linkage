package com.linkage.service.impl;

import com.linkage.dto.VideoDto;
import com.linkage.mapper.TopicMapper;
import com.linkage.mapper.VideoMapper;
import com.linkage.pojo.Video;
import com.linkage.service.VideoService;
import com.linkage.utils.FactoryUtil;
import com.linkage.vo.VideoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("VideoService")
public class VideoServiceImpl implements VideoService {
    @Resource
    VideoMapper videoMapper;
    @Resource
    TopicMapper topicMapper;
    @Override
    public List<VideoVo> getAllVideos() {
        List<VideoVo> videoVos=new ArrayList<>();
        for(VideoDto videoDto:videoMapper.selectAll()){
            videoVos.add(new VideoVo(
                    videoDto.getAvatarUrl(),
                    videoDto.getNickName(),
                    videoDto.getVideoName(),
                    videoDto.getVideoUrl(),
                    videoDto.getVideoImageUrl(),
                    videoDto.getVideoIntroduction(),
                    videoDto.getVideoLoveNumber(),
                    videoDto.getVideoDuration(),
                    videoDto.getVideoID()
                    )
            );
        }
        return videoVos;

    }
    @Override
    public VideoVo getVideoByVideoID(int videoID) {
        VideoDto videoDto=videoMapper.selectByVideoID(videoID);
        return FactoryUtil.createByVideoDto(videoDto);
    }
    @Override
    public List<VideoVo> getVideoByKeyword(String videoKeyword) {
        List<VideoVo> videoVos=new ArrayList<>();
        List<VideoDto> videoDtos = videoMapper.selectByVideoKeyword(videoKeyword);
        videoDtos.forEach(videoDto -> videoVos.add(FactoryUtil.createByVideoDto(videoDto)));
        return videoVos;
    }
    @Override
    public int addVideo(Video video) {
        video.setVideoLoveNumber(0);
        return videoMapper.addVideo(video);
    }

}
