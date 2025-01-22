package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.response.RoleResponse;

public interface RoleMapper {
    RoleResponse entityToResponse(Role role);
}
