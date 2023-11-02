package com.blog.app.blog.service.implementation;

import com.blog.app.blog.entity.Post;
import com.blog.app.blog.exception.ResourceNotFoundException;
import com.blog.app.blog.payload.PostDto;
import com.blog.app.blog.payload.PostResponse;
import com.blog.app.blog.repository.PostRepository;
import com.blog.app.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PostResponse getAllPost(int pageNumber,int pagesize,String sortBy)    {

        Pageable pageable= PageRequest.of(pageNumber,pagesize, Sort.by(sortBy));
        Page<Post> posts=postRepository.findAll(pageable);

        List<Post> listOfPosts=posts.getContent();
        List<PostDto>content= listOfPosts.stream().map(item->mapToDto(item)).collect(Collectors.toList());
        PostResponse postResponse=new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTottalElements(posts.getTotalElements());
        postResponse.setTottalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        return postResponse;

    }

    @Override
    public PostDto getPostById(long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));

        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post newPost=postRepository.save(post);
        return mapToDto(newPost);
    }

    @Override
    public void deletePost(long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);

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
