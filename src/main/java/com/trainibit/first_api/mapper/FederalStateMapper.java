package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.response.FederalStateResponse;

public interface FederalStateMapper {
    FederalStateResponse entityToResponse(FederalState federalState);
}
