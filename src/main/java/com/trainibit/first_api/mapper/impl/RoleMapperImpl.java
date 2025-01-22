package com.trainibit.first_api.mapper.impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.mapper.RoleMapper;
import com.trainibit.first_api.response.RoleResponse;
import org.springframework.stereotype.Service;

@Service
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleResponse entityToResponse(Role role) {
        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setName(role.getName());
        roleResponse.setCreatedDate(role.getCreatedDate());
        roleResponse.setUpdatedDate(role.getUpdatedDate());
        roleResponse.setUuid(role.getUuid());

        return roleResponse;
    }
}
