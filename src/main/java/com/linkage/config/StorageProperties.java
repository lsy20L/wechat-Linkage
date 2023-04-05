package com.linkage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
    private String active;
    private Local local;
    @Data
    public static class Local {
        private String address;
        private String storagePath;
    }
}
