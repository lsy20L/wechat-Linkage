package com.linkage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {
    private int videoID;
    private String  videoName;
    private String videoUrl;
    private String videoImageUrl;
    private String videoIntroduction;
    private int videoLoveNumber;
    private String videoDuration;
    private String nickName;
    private String avatarUrl;
}
