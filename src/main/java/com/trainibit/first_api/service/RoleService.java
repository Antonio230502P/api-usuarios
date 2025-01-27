package com.trainibit.first_api.service;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.request.RoleRequest;
import com.trainibit.first_api.response.RoleResponse;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<Role> getAllRoles();

    List<RoleResponse> getAllRoleResponses();

    RoleResponse getByUuid(UUID uuid);

    RoleResponse createRole(RoleRequest roleRequest);

    RoleResponse deleteResponse(UUID uuid);

    RoleResponse updateRole(UUID uuid, RoleRequest roleRequest);
}