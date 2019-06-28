package com.vadim.server.utility.converter;

import com.vadim.server.entity.PostEntity;
import com.vadim.server.model.PostModel;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PostConverter {

    public static PostModel toPostModel(PostEntity postEntity) {

        return new PostModel()
                .id(postEntity.getId())
                .content(postEntity.getContent())
                .title(postEntity.getTitle())
                .imageUrl(postEntity.getImageUrl());
    }

    public static List<PostModel> toPostModels(List<PostEntity> postEntities) {

        return postEntities.stream()
                .map(PostConverter::toPostModel)
                .collect(Collectors.toList());
    }

    public static PostEntity toBannerEntity(PostModel postModel) {

        return PostEntity.builder()
                .content(postModel.getContent())
                .title(postModel.getTitle())
                .imageUrl(postModel.getImageUrl())
                .build();
    }
}
