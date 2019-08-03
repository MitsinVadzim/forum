package com.vadim.server.controller;

import com.vadim.controllers.api.PostApi;
import com.vadim.model.rest.RestPostModel;
import com.vadim.server.service.PostService;
import com.vadim.server.utility.HeaderUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class PostApiController implements PostApi {

    private final PostService postService;

    @Override
    public ResponseEntity<List<RestPostModel>> getPosts(
            @Min(1) @Valid
            @RequestParam(value = "size", required = false, defaultValue = "10") final Integer page,
            @Min(10) @Max(30) @Valid
            @RequestParam(value = "size", required = false, defaultValue = "10") final Integer size
    ) {
        final Page<RestPostModel> postPage = postService.getPosts(page, size);
        final HttpHeaders headers = HeaderUtil.generatePaginationHeaders(getPostsPath, postPage);

        return new ResponseEntity<>(postPage.getContent(), headers, OK);
    }


}
