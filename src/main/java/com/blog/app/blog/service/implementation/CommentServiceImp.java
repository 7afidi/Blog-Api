package com.blog.app.blog.service.implementation;

import com.blog.app.blog.entity.Comment;
import com.blog.app.blog.entity.Post;
import com.blog.app.blog.exception.ResourceNotFoundException;
import com.blog.app.blog.payload.CommentDto;
import com.blog.app.blog.repository.CommentRepository;
import com.blog.app.blog.repository.PostRepository;
import com.blog.app.blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImp implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;
    @Autowired

    public CommentServiceImp(CommentRepository commentRepository, ModelMapper modelMapper, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }



    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment=modelMapper.map(commentDto,Comment.class);
        Post post=  postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("comment","id",postId));
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);
        return modelMapper.map(newComment,CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        List<Comment> comments=commentRepository.findByPostId(postId);
        return comments.stream().map((comment -> modelMapper.map(comment,CommentDto.class))).collect(Collectors.toList());
    }
}
