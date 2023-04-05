package com.linkage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    private  int textID;
    private String textName;
    private String textContent;
    private String textTopicName;
    private int textLoveNumber;
    private String[] textImageUrl;
    private String userID;
    private String textContactType;
    private String textContactNumber;
}
