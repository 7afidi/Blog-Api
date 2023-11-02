package com.blog.app.blog.controller;


import com.blog.app.blog.payload.PostDto;
import com.blog.app.blog.payload.PostResponse;
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
    public PostResponse getAllPosts(@RequestParam (value = "pageN",defaultValue = "10",required = false) int pageNumber,
                                    @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
                                    @RequestParam(value = "sortBy",defaultValue = "id",required = false)String sortBy,
                                    @RequestParam(value = "sortdir",defaultValue = "asc",required = false)String sortDir){
        return postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable("id") long postId){
        return ResponseEntity.ok((postService.getPostById(postId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable("id") long postId,@RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(postId,postDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable("id") long postId){
        postService.deletePost(postId);
        return new ResponseEntity("Post entity delete",HttpStatus.OK);
    }
}
