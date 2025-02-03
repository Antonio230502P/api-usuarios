package com.trainibit.first_api.mapper.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.request.FederalStateRequest;
import com.trainibit.first_api.response.FederalStateResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<FederalStateResponse> entityToResponseList(List<FederalState> federalStates) {
        List<FederalStateResponse> federalStateResponses = new ArrayList<>();
        federalStates.forEach(federalState -> federalStateResponses.add(entityToResponse(federalState)));
        return federalStateResponses;
    }

    @Override
    public FederalState requestToEntity(FederalStateRequest federalStateRequest) {
        FederalState federalState = new FederalState();
        federalState.setName(federalStateRequest.getName());
        return federalState;
    }
}