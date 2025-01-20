package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.FederalState;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FederalStateRepository {
    FederalState getFederalStateByUuid(UUID federalStateUuid);
}
