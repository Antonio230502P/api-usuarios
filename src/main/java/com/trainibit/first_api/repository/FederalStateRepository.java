package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.FederalState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FederalStateRepository extends JpaRepository<FederalState, Long> {
    @NonNull
    List<FederalState> findAll();

    FederalState getFederalStateByUuid(UUID federalStateUuid);
}