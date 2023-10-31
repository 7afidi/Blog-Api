package com.blog.app.blog.service.implementation;

import com.blog.app.blog.entity.Post;
import com.blog.app.blog.exception.ResourceNotFoundException;
import com.blog.app.blog.payload.PostDto;
import com.blog.app.blog.repository.PostRepository;
import com.blog.app.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        Post post=mapToEntity(postDto);
        Post newPost=postRepository.save(post);
        return mapToDto(newPost);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts=postRepository.findAll();
        return posts.stream().map(item->mapToDto(item)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));

        return mapToDto(post);
    }

    private Post mapToEntity(PostDto postDto){
        Post post=modelMapper.map(postDto,Post.class);
        return post;
    }
    private PostDto mapToDto(Post post){
        PostDto postDto=modelMapper.map(post,PostDto.class);
        return postDto;
    }
}
