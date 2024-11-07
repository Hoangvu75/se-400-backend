package com.example.multimodule.application.mapper;


import com.example.multimodule.application.dto.request.UserCreationRequest;
import com.example.multimodule.application.dto.request.UserUpdateRequest;
import com.example.multimodule.application.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.multimodule.application.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
