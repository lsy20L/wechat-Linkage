package com.linkage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextVo {
    private String userImageUrl;
    private String userName;
    private String textName;
    private String textContent;
    private String[] textImageUrl;
    private String topicName;
    private int textLoveNumber;
    private String textContactType;
    private String textContactNumber;
    private int textID;

}
