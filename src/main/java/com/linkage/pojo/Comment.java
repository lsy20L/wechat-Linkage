package com.linkage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentID;
    private int typeID;
    private int type;
    private String userID;
    private String commentContent;


}
