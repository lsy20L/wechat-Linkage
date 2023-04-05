package com.linkage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoragePojo {
        public static final Boolean IS_DELETED = Boolean.valueOf("1");
        public static final Boolean NOT_DELETED = Boolean.valueOf("0");
        private Integer id;
        private String key;
        private String name;
        private String type;
        private Integer size;
        private String url;
        private LocalDateTime addTime;
        private LocalDateTime updateTime;
        private Boolean deleted;

}
