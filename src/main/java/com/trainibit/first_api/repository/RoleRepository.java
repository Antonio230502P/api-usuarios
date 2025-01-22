package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByUuid(UUID roleUuid);
}
