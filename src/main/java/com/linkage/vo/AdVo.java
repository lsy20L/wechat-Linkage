package com.linkage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdVo {
    private Integer adID;
    private String adName;
    private  String adImageUrl;
    private String adLink;


}
