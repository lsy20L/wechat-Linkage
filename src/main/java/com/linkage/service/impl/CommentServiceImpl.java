package com.linkage.service.impl;

import com.linkage.dto.CommentDto;
import com.linkage.mapper.CommentMapper;
import com.linkage.pojo.Comment;
import com.linkage.service.CommentService;
import com.linkage.vo.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public List<CommentVo> getAllComments(int typeID, int type) {
        List<CommentDto> allComments = commentMapper.getAllComments(typeID, type);
        List<CommentVo> commentVos=new ArrayList<>();
        allComments.forEach(commentDto -> commentVos.add(new CommentVo(commentDto.getCommentContent(),commentDto.getNickName(),commentDto.getAvatarUrl())));
        return commentVos;
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
