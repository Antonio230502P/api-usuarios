package com.trainibit.first_api.service;

import com.trainibit.first_api.request.FederalStateRequest;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.FederalStateResponse;

import java.util.List;
import java.util.UUID;

public interface FederalStateService {
    FederalStateResponse getFederalStateByUuid(UUID uuid);
    List<FederalStateResponse> getAllFederalStates();
    FederalStateResponse createFederalState(FederalStateRequest federalStateRequest);
    FederalStateResponse updateFederalState(UUID uuid, UserRequestPut userRequestPost);
}
