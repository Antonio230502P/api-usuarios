package com.trainibit.first_api.service;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface FederalStateService {
    FederalState getFederalStateByUuid(UUID uuid);
    List<FederalState> getAllFederalStates();
    UserResponse createFederalState(UserRequestPost userRequestPost);
    UserResponse updateFederalState(UUID uuid, UserRequestPut userRequestPost);
}
