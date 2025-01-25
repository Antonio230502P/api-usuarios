package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.request.FederalStateRequest;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.FederalStateService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FederalStateServiceImpl implements FederalStateService {
    @Autowired
    private FederalStateRepository federalStateRepository;

    @Autowired
    private FederalStateMapper federalStateMapper;

    @Override
    //@Cacheable(value = "federal-state", key="#uuid")
    public FederalStateResponse getFederalStateByUuid(UUID uuid) {
        log.info("Obteniendo de la BD: Federal State getByUuid {}", uuid);
        return federalStateMapper.entityToResponse(federalStateRepository.getFederalStateByUuid(uuid));
    }

    @Override
    public List<FederalStateResponse> getAllFederalStates() {
        log.info("Obteniendo todas las entidades federativas desde la base de datos");
        return federalStateMapper.entityToResponseList(federalStateRepository.findAll());
    }

    @Override
    public FederalStateResponse createFederalState(FederalStateRequest federalStateRequest) {
        FederalState newFederalState = federalStateMapper.requestToEntity(federalStateRequest);
        newFederalState.setUuid(UUID.randomUUID());

        return federalStateMapper.entityToResponse(federalStateRepository.save(newFederalState));
    }

    @Override
    public FederalStateResponse updateFederalState(UUID uuid, UserRequestPut userRequestPost) {
        return null;
    }
}
