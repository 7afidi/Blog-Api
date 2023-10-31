package com.blog.app.blog.repository;

import com.blog.app.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository  extends JpaRepository<Post,Long> {

}
