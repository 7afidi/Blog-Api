package com.blog.app.blog.service;

import com.blog.app.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost (PostDto postDto);
    List<PostDto> getAllPost();

}
