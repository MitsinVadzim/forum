package com.vadim.server.security;


import com.vadim.model.rest.RestTokenModel;
import com.vadim.server.entity.UserEntity;

public interface TokenProvider {

    RestTokenModel createTokenModel(UserEntity userEntity);

    RestTokenModel refreshToken(String refreshToken);

    UserEntity buildUserEntityByToken(String token);
}
