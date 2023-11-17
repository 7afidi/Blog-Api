package com.blog.app.blog.service;

import com.blog.app.blog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(Long postId,CommentDto commentDto);
}
