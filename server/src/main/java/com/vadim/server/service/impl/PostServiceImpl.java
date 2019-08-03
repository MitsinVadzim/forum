package com.vadim.server.service.impl;

import com.vadim.model.rest.RestPostModel;
import com.vadim.server.repository.PostRepository;
import com.vadim.server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Page<RestPostModel> getPosts(final Integer page, final Integer size) {
        return null;
    }

    @Override
    @Transactional
    public RestPostModel createPost(final RestPostModel postModel) {
        return null;
    }

    @Override
    @Transactional
    public void deletePost(final UUID postId) {
        postRepository.deleteById(postId);
    }

    @Override
    @Transactional
    public RestPostModel getPost(final UUID postId) {
        return null;
    }
}
