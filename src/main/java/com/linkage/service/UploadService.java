package com.linkage.service;

import com.linkage.pojo.StoragePojo;

public interface UploadService {
    void add(StoragePojo storageInfo);

    StoragePojo findByKey(String key);
}
