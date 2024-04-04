package com.example.BBS.domain.post;

import java.util.List;

public interface PostService {
    public List<PostDto> postList();

    public PostDto findById(Long postId);

    public Long add(PostDto postDto);

    public Long update(PostDto postDto);

    public void deleteById(Long postId);
}
