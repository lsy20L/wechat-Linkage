package com.linkage.config;

import com.linkage.pojo.StoragePojo;
import com.linkage.service.UploadService;
import com.linkage.utils.CharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;

import java.io.InputStream;


public class StorageService {
    private String active;
    private Storage storage;
    @Autowired
    @Qualifier("UploadService")
    private UploadService uploadService;
    public void setActive(String active) {
        this.active = active;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    public Resource loadAsResource(String keyName) {
        return storage.loadAsResource(keyName);
    }
    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public StoragePojo store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, fileName,key);
        String url = generateUrl(key);
        StoragePojo storageInfo = new StoragePojo();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setType(contentType);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        uploadService.add(storageInfo);
        return storageInfo;
    }

    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);

        String key = null;
        StoragePojo storageInfo = null;

        do {
            key = CharUtil.getRandomNum(20) + suffix;
            storageInfo = uploadService.findByKey(key);
        }
        while (storageInfo != null);

        return key;
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
