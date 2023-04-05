package com.linkage.service.impl;

import com.linkage.dto.AdDto;
import com.linkage.mapper.AdMapper;
import com.linkage.service.AdService;
import com.linkage.vo.AdVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("AdService")
public class AdServiceImpl implements AdService {
    @Resource
    AdMapper adMapper;
    @Override
    public List<AdVo> getAllAds() {
        List<AdVo> adVoList=new ArrayList<>();
        List<AdDto> allAds = adMapper.getAllAds();
        allAds.forEach(adDto -> adVoList.add(new AdVo(adDto.getAdID(),adDto.getAdName(),adDto.getAdImageUrl(),adDto.getAdLink())));
        return adVoList;
    }
}
