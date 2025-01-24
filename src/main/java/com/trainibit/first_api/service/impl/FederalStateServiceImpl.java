package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.FederalStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FederalStateServiceImpl implements FederalStateService {
    @Autowired
    private FederalStateRepository federalStateRepository;

    @Override
    @Cacheable(value = "federal-state", key="#uuid")
    public FederalState getFederalStateByUuid(UUID uuid) {
        log.info("Obteniendo de la BD: Federal State getByUuid {}", uuid);
        return federalStateRepository.getFederalStateByUuid(uuid);
    }

    @Override
    public List<FederalState> getAllFederalStates() {
        return federalStateRepository.findAll();
    }

    @Override
    public UserResponse createFederalState(UserRequestPost userRequestPost) {
        return null;
    }

    @Override
    public UserResponse updateFederalState(UUID uuid, UserRequestPut userRequestPost) {
        return null;
    }
}
