package com.blog.app.blog.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(
        name = "posts"
)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "content",nullable = false)
    private String content;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments=new ArrayList<>();

}
