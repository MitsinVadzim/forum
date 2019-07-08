package com.vadim.server.controller;

import com.vadim.server.model.PostModel;
import com.vadim.server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

import static com.vadim.server.utility.HeaderUtility.createPaginationHeaders;
import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
public class PostApiController implements PostApi {

    private final PostService postService;

    @Override
    public ResponseEntity<PostModel> createPost(@Valid @RequestBody PostModel postModel) {
        final PostModel createdPost = postService.createPost(postModel);
        return new ResponseEntity<>(createdPost, CREATED);
    }

    @Override
    public ResponseEntity<Void> deletePost(@PathVariable("postId") UUID postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @Override
    public ResponseEntity<PostModel> getPost(@PathVariable("postId") UUID postId) {
        final PostModel postModel = postService.getPost(postId);
        return new ResponseEntity<>(postModel, OK);
    }

    @Override
    public ResponseEntity<List<PostModel>> getPosts(@Min(1) @Valid Integer page, @Min(10) @Max(30) @Valid Integer size) {
        final Page<PostModel> postPage = postService.getPosts(page, size);
        final HttpHeaders headers = createPaginationHeaders(postPage, getPostsPath);

        return new ResponseEntity<>(postPage.getContent(), headers, OK);
    }


}
