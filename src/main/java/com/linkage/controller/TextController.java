package com.linkage.controller;

import com.linkage.pojo.Text;
import com.linkage.service.CommentService;
import com.linkage.service.TextService;
import com.linkage.service.TopicService;
import com.linkage.utils.ResponseUtil;
import com.linkage.vo.CommentVo;
import com.linkage.vo.TextVo;
import com.linkage.vo.TopicVo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/text")
public class TextController {
    @Resource
    @Qualifier("TextService")
    private TextService textService;
    @Resource
    @Qualifier("TopicService")
    private TopicService topicService;
    @Resource
    @Qualifier("CommentService")
    private CommentService commentService;
    @GetMapping("/index")
    public Object index(){
        List<TextVo> allTexts = textService.getAllTexts();
        List<TopicVo> textTopics = topicService.getTopics(0);
        Map<String,Object> res = new HashMap<>();
        res.put("topics",textTopics);
        res.put("texts",allTexts);
        return ResponseUtil.ok(res);
    }
    @GetMapping("/topic")
    public Object topic(Integer id){
        List<TopicVo> textTopics = topicService.getTopics(0);
        String topicName = topicService.getTopicNameByTopicID(id);
        Map<String,Object> res = new HashMap<>();
        res.put("topics",textTopics);
        res.put("topicName",topicName);
        return ResponseUtil.ok(res);
    }

    @GetMapping("/list")
    public Object list(Integer id){
        List<TextVo> textByTopicID = textService.getTextByTopicID(id);
        Map<String,Object> res= new HashMap<>();
        res.put("texts",textByTopicID);
        return ResponseUtil.ok(res);
    };

    @GetMapping("/detail")
    public Object detail(Integer textID){
        TextVo textByTextID = textService.getTextByTextID(textID);
        List<CommentVo> allComments = commentService.getAllComments(textID, 0);
        Map<String,Object> res=new HashMap<>();
        res.put("text",textByTextID);
        res.put("comments",allComments);
        return ResponseUtil.ok(res);
    }
    @PostMapping("/add")
    public Object add(@RequestBody Text text){
        textService.addText(text);
        return ResponseUtil.ok();
    }


}
