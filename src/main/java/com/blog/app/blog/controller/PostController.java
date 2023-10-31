package com.blog.app.blog.controller;


import com.blog.app.blog.payload.PostDto;
import com.blog.app.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity createPost (@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable("id") long postId){
        return ResponseEntity.ok((postService.getPostById(postId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable("id") long postId,@RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(postId,postDto));
    }
}
