package com.linkage.service;

import com.linkage.pojo.Video;
import com.linkage.vo.VideoVo;

import java.util.List;

public interface VideoService {
    List<VideoVo> getAllVideos();
    VideoVo getVideoByVideoID(int videoID);
    List<VideoVo> getVideoByKeyword(String videoKeyword);
    int addVideo(Video video);
}
