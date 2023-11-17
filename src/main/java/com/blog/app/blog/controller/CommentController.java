package com.blog.app.blog.controller;

import com.blog.app.blog.payload.CommentDto;
import com.blog.app.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name = "postId") long id, @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }


    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(name = "postId") long postId) {

        return commentService.getCommentsByPostId(postId);

    }
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name = "postId") long postId, @PathVariable(name = "commentId") long commentID) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentID), HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "postId") long postId, @PathVariable long commentId,@RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.updateComment(postId, commentId,commentDto), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable(name = "postId") long postId, @PathVariable long commentId) {

        commentService.deleteComment(postId,commentId);
        return new ResponseEntity<>("Comment Deleted successfully",HttpStatus.OK);

    }
}
