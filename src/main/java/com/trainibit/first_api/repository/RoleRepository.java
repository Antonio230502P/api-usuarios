package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.Role;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByUuid(UUID roleUuid);
}
