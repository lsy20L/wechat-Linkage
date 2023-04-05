package com.linkage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdDto {
    private Integer adID;
    private String adName;
    private  String adImageUrl;
    private String adLink;
}
