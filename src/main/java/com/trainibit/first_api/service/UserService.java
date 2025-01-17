package com.trainibit.first_api.service;

import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();
    UserResponse getByUuid(String id);
    UserResponse createUser(UserRequestPost userRequestPost);
    UserResponse deleteUser(String uuid);
    UserResponse updateUser(String uuid, UserRequestPut userRequestPost);
}
