package com.linkage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextDto {
    private int textID;
    private String textContactType;
    private String textContactNumber;
    private String textContent;
    private String textName;
    private String textImageUrl;
    private String topicName;
    private int textLoveNumber;
    private String nickName;
    private String avatarUrl;

}
