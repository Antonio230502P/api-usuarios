package com.trainibit.first_api.mapper.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.response.FederalStateResponse;
import org.springframework.stereotype.Service;

@Service
public class FederalStateMapperImpl implements FederalStateMapper {
    @Override
    public FederalStateResponse entityToResponse(FederalState federalState) {
        FederalStateResponse federalStateResponse = new FederalStateResponse();
        federalStateResponse.setName(federalState.getName());
        federalStateResponse.setCreatedDate(federalState.getCreatedDate());
        federalStateResponse.setUpdatedDate(federalState.getUpdatedDate());
        federalStateResponse.setUuid(federalState.getUuid());
        return federalStateResponse;
    }
}
