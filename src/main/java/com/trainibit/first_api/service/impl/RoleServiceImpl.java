package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.mapper.RoleMapper;
import com.trainibit.first_api.repository.RoleRepository;
import com.trainibit.first_api.request.RoleRequest;
import com.trainibit.first_api.response.RoleResponse;
import com.trainibit.first_api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<RoleResponse> getAllRoleResponses() {
        return roleMapper.entityToResponseList(roleRepository.findAll());
    }

    @Override
    public RoleResponse getByUuid(UUID uuid) {
        return roleMapper.entityToResponse(roleRepository.getRoleByUuid(uuid));
    }

    @Override
    public RoleResponse createRole(RoleRequest roleRequest) {
        Role newRole = roleMapper.requestToEntity(roleRequest);
        newRole.setUuid(UUID.randomUUID());
        return roleMapper.entityToResponse(roleRepository.save(newRole));
    }

    @Override
    public RoleResponse deleteResponse(UUID uuid) {
        Role roleToDelete = roleRepository.getRoleByUuid(uuid);
        roleRepository.delete(roleToDelete);
        return roleMapper.entityToResponse(roleToDelete);
    }

    @Override
    public RoleResponse updateRole(UUID uuid, RoleRequest roleRequest) {
        Role existentRole = roleRepository.getRoleByUuid(uuid);
        existentRole.setName(roleRequest.getName());
        return roleMapper.entityToResponse(roleRepository.save(existentRole));
    }
}