package com.linkage.mapper;

import com.linkage.dto.VideoDto;
import com.linkage.pojo.Video;
import com.linkage.vo.VideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {
    List<VideoDto> selectAll();
    VideoDto selectByVideoID(@Param("videoID") int videoID);
    List<VideoDto> selectByUserID(@Param("userID")String userID);
    List<VideoDto> selectByVideoKeyword(@Param("videoKeyword")String videoKeyword);
    int addVideo(Video video);

}
