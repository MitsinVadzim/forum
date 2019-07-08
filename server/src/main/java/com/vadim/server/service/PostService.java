package com.vadim.server.service;

import com.vadim.server.model.PostModel;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PostService {
    Page<PostModel> getPosts(Integer page, Integer size);

    PostModel createPost(PostModel postModel);

    void deletePost(UUID postId);

    PostModel getPost(UUID postId);
}
