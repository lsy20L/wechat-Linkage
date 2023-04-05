package com.linkage.controller;

import com.linkage.pojo.Video;
import com.linkage.service.CommentService;
import com.linkage.service.VideoService;
import com.linkage.utils.ResponseUtil;
import com.linkage.vo.CommentVo;
import com.linkage.vo.VideoVo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/wx/video")
public class VideoController {
    @Resource
    @Qualifier("VideoService")
    private VideoService videoService;
    @Resource
    @Qualifier("CommentService")
    private CommentService commentService;

    @GetMapping("/list")
    public List<VideoVo> getAllVideos(){
        return videoService.getAllVideos();
    };
    @GetMapping("/detail")
    public Object getVideoByVideoID( Integer videoID){
        VideoVo videoVo = videoService.getVideoByVideoID(videoID);
        List<CommentVo> commentVos=commentService.getAllComments(videoID,1);
        Map<String,Object> res=new HashMap<>();
        res.put("video",videoVo);
        res.put("comments",commentVos);
        return ResponseUtil.ok(res);
    }
    @GetMapping("/search")
    public Object getVideoByKeyword(String keyword){
        List<VideoVo> video = videoService.getVideoByKeyword(keyword);
        Map<String,Object> res = new HashMap<>();
        res.put("videos",video);
        return ResponseUtil.ok(res);
    }
    @PostMapping("/add")
    public Object add(@RequestBody Video video){
        videoService.addVideo(video);
        return ResponseUtil.ok();
    }

}
