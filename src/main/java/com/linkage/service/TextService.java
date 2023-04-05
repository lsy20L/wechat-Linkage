package com.linkage.service;

import com.linkage.pojo.Text;
import com.linkage.vo.TextVo;

import java.util.List;

public interface TextService {
    List<TextVo> getAllTexts();
    TextVo getTextByTextID(int textID);
    int addText(Text text);
    List<TextVo> getTextByTopicID(int topicID);
}
