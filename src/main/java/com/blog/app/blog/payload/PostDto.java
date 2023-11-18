package com.blog.app.blog.payload;


import com.blog.app.blog.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private List<Comment> comments;
}
