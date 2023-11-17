package com.blog.app.blog.payload;

import com.blog.app.blog.entity.Post;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
