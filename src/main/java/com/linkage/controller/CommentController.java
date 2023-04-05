package com.linkage.controller;

import com.linkage.pojo.Comment;
import com.linkage.service.CommentService;
import com.linkage.service.TextService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wx/comment")
public class CommentController {
    @Resource
    @Qualifier("CommentService")
    private CommentService commentService;
    @Resource
    @Qualifier("TextService")
    private TextService textService;
    @PostMapping("/add")
    public int addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
