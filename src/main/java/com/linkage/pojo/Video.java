package com.linkage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private int videoID;
    private String videoName;
    private String videoUrl;
    private String videoImageUrl;
    private String videoIntroduction;
    private  int videoLoveNumber;
    private String userID;
    private String videoDuration;

}
