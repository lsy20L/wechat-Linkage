package com.linkage.mapper;

import com.linkage.dto.CommentDto;
import com.linkage.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDto> getAllComments(@Param("typeID")int typeID,@Param("type")int type);
    int addComment(Comment comment);

}
