package com.vadim.server.service.impl;

import com.vadim.server.model.PostModel;
import com.vadim.server.repository.PostRepository;
import com.vadim.server.service.PostService;
import com.vadim.server.utility.converter.PostConverter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Page<PostModel> getPosts(Integer page, Integer size) {
        return postRepository.findAll(PageRequest.of(page - 1,size)).map(PostConverter::toPostModel);
    }
}
