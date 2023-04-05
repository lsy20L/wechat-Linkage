package com.linkage.mapper;

import com.linkage.dto.TextDto;
import com.linkage.pojo.Text;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TextMapper {
    List<TextDto> selectAll();
    TextDto selectByTextID(@Param("textID") int textID);
    List<TextDto> selectByUserID(@Param("userID")String userID);
    List<TextDto> selectByTextKeyword(@Param("textKeyword")String textKeyword);
    int addText(Text text);
    List<TextDto> selectByTopicID(@Param("topicID")int topicID);
}
