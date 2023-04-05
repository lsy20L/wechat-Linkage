package com.linkage.service.impl;

import com.linkage.mapper.UploadMapper;
import com.linkage.pojo.StoragePojo;
import com.linkage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("UploadService")
public class UploadServiceImpl implements UploadService {
    @Autowired
    UploadMapper uploadMapper;
    @Override
    public void add(StoragePojo storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        uploadMapper.insertSelective(storageInfo);
    }

    @Override
    public StoragePojo findByKey(String key) {
        return uploadMapper.selectOneBykey(key);
    }
}
