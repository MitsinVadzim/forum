package com.vadim.server.service;

import com.vadim.model.rest.RestPostModel;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PostService {
    Page<RestPostModel> getPosts(Integer page, Integer size);

    RestPostModel createPost(RestPostModel postModel);

    void deletePost(UUID postId);

    RestPostModel getPost(UUID postId);
}
