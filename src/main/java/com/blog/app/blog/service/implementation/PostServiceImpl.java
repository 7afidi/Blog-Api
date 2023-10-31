package com.blog.app.blog.service.implementation;

import com.blog.app.blog.payload.PostDto;
import com.blog.app.blog.repository.PostRepository;
import com.blog.app.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;


    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public PostDto createPost(PostDto postDto) {
        return null;
    }
}
