package com.linkage.service;

import com.linkage.pojo.Comment;
import com.linkage.vo.CommentVo;

import java.util.List;

public interface CommentService {
    List<CommentVo> getAllComments(int typeID,int type);
    int addComment(Comment comment);
}
