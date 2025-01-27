package com.trainibit.first_api.service;

import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> getAll();

    UserResponse getByUuid(UUID id);

    UserResponse createUser(UserRequestPost userRequestPost);

    UserResponse deleteUser(UUID uuid);

    UserResponse updateUser(UUID uuid, UserRequestPut userRequestPost);
}