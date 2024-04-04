package com.example.BBS.mapper;

import com.example.BBS.domain.post.PostDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PostMapper {

    int postCount();

    PostDto findById(Long postId);

    List<PostDto> findAll();

    Long add(PostDto postDto);

    Long update(PostDto postDto);

    void delete(Long postId);
}
