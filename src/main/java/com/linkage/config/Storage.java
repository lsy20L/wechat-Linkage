package com.linkage.config;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;

public interface Storage {

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param keyName       文件名
     */
    void store(InputStream inputStream, long contentLength, String contentType,String fileName, String keyName);
    Path load(String keyName);
    String generateUrl(String keyName);
    Resource loadAsResource(String keyName);
}
