package com.linkage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoVo {
    private String userImageUrl;
    private String userName;
    private String videoName;
    private String videoUrl;
    private String videoImageUrl;
    private String videoIntroduction;
    private  int videoLoveNumber;
    private String videoDuration;
    private int videoID;

}
