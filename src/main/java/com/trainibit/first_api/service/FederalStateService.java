package com.trainibit.first_api.service;

import com.trainibit.first_api.request.FederalStateRequest;
import com.trainibit.first_api.response.FederalStateResponse;

import java.util.List;
import java.util.UUID;

public interface FederalStateService {
    FederalStateResponse getFederalStateByUuid(UUID uuid);

    List<FederalStateResponse> getAllFederalStates();

    FederalStateResponse createFederalState(FederalStateRequest federalStateRequest);

    FederalStateResponse deleteFederalState(UUID uuid);

    FederalStateResponse updateFederalState(UUID uuid, FederalStateRequest federalStateRequest);
}