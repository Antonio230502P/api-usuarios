package com.trainibit.first_api.service;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAllRoles();
}
