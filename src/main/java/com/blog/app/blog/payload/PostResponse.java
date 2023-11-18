package com.blog.app.blog.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private long tottalElements;
    private int tottalPages;
    private boolean last;


}
