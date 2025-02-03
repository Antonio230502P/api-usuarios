package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.request.FederalStateRequest;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.service.FederalStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
    @Cacheable(value = "federalState", key="#uuid")
    public FederalStateResponse getFederalStateByUuid(UUID uuid) {
        log.info("Obteniendo de la BD: Federal State getByUuid {}", uuid);
        return federalStateMapper.entityToResponse(federalStateRepository.getFederalStateByUuid(uuid));
    }

    @Override
    @Cacheable(value = "federalStates", key = "'all'")
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
    @CacheEvict(cacheNames = "federalState", key = "#uuid", beforeInvocation = true)
    public FederalStateResponse deleteFederalState(UUID uuid) {
        FederalState federalState = federalStateRepository.getFederalStateByUuid(uuid);
        federalStateRepository.delete(federalState);
        return federalStateMapper.entityToResponse(federalState);
    }

    @Override
    @CachePut(cacheNames = "federalState", key="#uuid")
    public FederalStateResponse updateFederalState(UUID uuid, FederalStateRequest federalStateRequest) {
        FederalState currentFederalState = federalStateRepository.getFederalStateByUuid(uuid);
        currentFederalState.setName(federalStateRequest.getName());
        return federalStateMapper.entityToResponse(federalStateRepository.save(currentFederalState));
    }
}