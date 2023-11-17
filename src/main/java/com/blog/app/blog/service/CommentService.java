package com.blog.app.blog.service;

import com.blog.app.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long postId,CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(Long postId,Long id);
    CommentDto updateComment(Long postId,Long commentId,CommentDto commentDto);
    void deleteComment(Long postId,Long commentId);

}
