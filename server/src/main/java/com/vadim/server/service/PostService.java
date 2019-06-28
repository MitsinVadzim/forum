package com.vadim.server.service;

import com.vadim.server.model.PostModel;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<PostModel> getPosts(Integer page, Integer size);
}
