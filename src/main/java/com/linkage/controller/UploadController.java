package com.linkage.controller;

import com.linkage.config.StorageService;
import com.linkage.pojo.StoragePojo;
import com.linkage.service.UploadService;
import com.linkage.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/wx/upload")
public class UploadController {
    @Resource
    @Qualifier("UploadService")
    private UploadService uploadService;

    @Autowired
    private StorageService storageService;
    @PostMapping("/storage")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        StoragePojo Storage = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
        return ResponseUtil.ok(Storage);
    }
    @GetMapping("/fetch/{key:.+}")
    public ResponseEntity<org.springframework.core.io.Resource> fetch(@PathVariable String key) {

        StoragePojo storage = uploadService.findByKey(key);
        if (key == null) {
            return ResponseEntity.notFound().build();
        }
        if (key.contains("../")) {
            return ResponseEntity.badRequest().build();
        }
        String type = storage.getType();
        MediaType mediaType = MediaType.parseMediaType(type);

        org.springframework.core.io.Resource file = storageService.loadAsResource(key);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(mediaType).body(file);
    }
}
