package com.example.BBS.domain.post;

import com.example.BBS.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    public int postCount() {
        return postMapper.postCount();
    }

    public PostDto findById(Long postId) {
        return postMapper.findById(postId);
    }

    @Override
    public List<PostDto> postList() {
        return postMapper.findAll();
    }

    @Transactional
    public Long add(PostDto postDto) {
        postMapper.add(postDto);

        return postDto.getPostId();
    }

    @Transactional
    public Long update(PostDto postDto){
        return postMapper.update(postDto);
    }
    public void deleteById(Long postId) {
        postMapper.delete(postId);
    }

}
