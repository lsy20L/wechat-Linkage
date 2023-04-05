package com.linkage.service.impl;

import com.linkage.dto.TextDto;
import com.linkage.mapper.TextMapper;
import com.linkage.mapper.TopicMapper;
import com.linkage.pojo.Text;
import com.linkage.service.TextService;
import com.linkage.utils.FactoryUtil;
import com.linkage.vo.TextVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("TextService")
public class TextServiceImpl implements TextService {
    @Resource
    TextMapper textMapper;
    @Resource
    TopicMapper topicMapper;


    @Override
    public List<TextVo> getTextByTopicID(int topicID) {
        List<TextVo> textVos=new ArrayList<>();
        List<TextDto> textDtos = textMapper.selectByTopicID(topicID);
        textDtos.forEach(textDto -> textVos.add(FactoryUtil.createByTextDto(textDto)));
        return textVos;
    }

    @Override
    public List<TextVo> getAllTexts() {
        List<TextVo> textVos=new ArrayList<>();
        List<TextDto> textDtos = textMapper.selectAll();
        textDtos.forEach(textDto -> textVos.add(FactoryUtil.createByTextDto(textDto)));
        return textVos;
    }

    @Override
    public TextVo getTextByTextID(int textID) {
        TextDto textDto=textMapper.selectByTextID(textID);
        return FactoryUtil.createByTextDto(textDto);
    }


    @Override
    public int addText(Text text) {
        text.setTextLoveNumber(0);
        return textMapper.addText(text);
    }

}
