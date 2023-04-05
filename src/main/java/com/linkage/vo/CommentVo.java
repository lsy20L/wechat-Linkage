package com.linkage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private String commentContent;
    private String userName;
    private String userImageUrl;
    public String getCommentContent() {
        return commentContent;
    }


}
