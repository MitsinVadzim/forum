package com.vadim.server.utility.converter;

import com.vadim.model.rest.RestPostModel;
import com.vadim.server.entity.PostEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PostConverter {

    public static RestPostModel toPostModel(final PostEntity postEntity) {

        return new RestPostModel()
                .id(postEntity.getId())
                .content(postEntity.getContent())
                .title(postEntity.getTitle())
                .imageUrl(postEntity.getImageUrl());
    }

    public static List<RestPostModel> toPostModels(final List<PostEntity> postEntities) {

        return postEntities.stream()
                .map(PostConverter::toPostModel)
                .collect(Collectors.toList());
    }

    public static PostEntity toPostEntity(final RestPostModel postModel) {

        return PostEntity.builder()
                .content(postModel.getContent())
                .title(postModel.getTitle())
                .imageUrl(postModel.getImageUrl())
                .build();
    }
}
