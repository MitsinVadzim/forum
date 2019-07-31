package com.vadim.server.service.impl;

import com.vadim.model.rest.RestPostModel;
import com.vadim.server.entity.PostEntity;
import com.vadim.server.exception.NotFoundException;
import com.vadim.server.repository.PostRepository;
import com.vadim.server.service.PostService;
import com.vadim.server.utility.converter.PostConverter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return postRepository.findAll(PageRequest.of(page - 1, size)).map(PostConverter::toPostModel);
    }

    @Override
    @Transactional
    public RestPostModel createPost(final RestPostModel postModel) {
        final PostEntity entity = PostConverter.toPostEntity(postModel);
        return PostConverter.toPostModel(postRepository.saveAndFlush(entity));
    }

    @Override
    @Transactional
    public void deletePost(final UUID postId) {
        postRepository.deleteById(postId);
    }

    @Override
    @Transactional
    public RestPostModel getPost(final UUID postId) {
        return postRepository.findById(postId)
                .map(PostConverter::toPostModel)
                .orElseThrow(() -> new NotFoundException("This id does not exist."));
    }
}
