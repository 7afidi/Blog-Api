package com.blog.app.blog.service;

import com.blog.app.blog.payload.PostDto;
import com.blog.app.blog.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost (PostDto postDto);
    PostResponse getAllPost(int pageNumber, int pagesize);
    PostDto getPostById(long id);
    PostDto updatePost(long id,PostDto postDto);

}
