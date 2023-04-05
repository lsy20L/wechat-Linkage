package com.linkage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicVo {
    private  int topicID;
    private String topicName;
    private String topicImageUrl;

}
