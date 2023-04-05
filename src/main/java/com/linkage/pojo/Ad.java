package com.linkage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ad {
    private Integer adID;
    private String adName;
    private  String adImageUrl;
    private String adLink;
}
