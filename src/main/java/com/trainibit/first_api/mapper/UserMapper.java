package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;

public interface UserMapper {
    UserResponse entityToResponse(User user);

    List<UserResponse> entityToResponseList(List<User> userList);

    User requestToEntity(UserRequestPost userRequest);
}