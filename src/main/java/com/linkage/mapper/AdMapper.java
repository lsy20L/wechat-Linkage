package com.linkage.mapper;

import com.linkage.dto.AdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdMapper {
    List<AdDto> getAllAds();
}
