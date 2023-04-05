package com.linkage.mapper;

import com.linkage.pojo.StoragePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UploadMapper {
    void insertSelective(StoragePojo storageInfo);

    StoragePojo selectOneBykey(@Param("key") String key);
}
