package com.trainibit.first_api.mapper.impl;

import com.trainibit.first_api.entity.RolesByUser;
import com.trainibit.first_api.mapper.RoleMapper;
import com.trainibit.first_api.mapper.RolesByUserMapper;
import com.trainibit.first_api.response.RolesByUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesByUserMapperImpl implements RolesByUserMapper {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RolesByUserResponse entityToResponse(RolesByUser rolesByUser) {
        RolesByUserResponse rolesByUserResponse = new RolesByUserResponse();

        rolesByUserResponse.setUser(rolesByUser.getUser());
        rolesByUserResponse.setRole(roleMapper.entityToResponse(rolesByUser.getRole()));
        rolesByUserResponse.setCreatedDate(rolesByUser.getCreatedDate());
        rolesByUserResponse.setUpdatedDate(rolesByUser.getUpdatedDate());
        rolesByUserResponse.setUuid(rolesByUser.getUuid());

        return rolesByUserResponse;
    }

    @Override
    public List<RolesByUserResponse> entityToResponseList(List<RolesByUser> rolesByUsers) {
        List<RolesByUserResponse> rolesByUserResponseList = new ArrayList<>();
        rolesByUsers.forEach(rolesByUser -> rolesByUserResponseList.add(entityToResponse(rolesByUser)));
        return rolesByUserResponseList;
    }
}
