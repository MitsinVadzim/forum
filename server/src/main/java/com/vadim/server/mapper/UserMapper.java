package com.vadim.server.mapper;

import com.vadim.server.entity.enums.UserRoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(
        imports = {
                UUID.class,
                UserRoleEntity.class
        }
)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
