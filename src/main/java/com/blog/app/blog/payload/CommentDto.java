package com.blog.app.blog.payload;

import com.blog.app.blog.entity.Comment;
import com.blog.app.blog.entity.Post;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
