package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.mapper.RoleMapper;
import com.trainibit.first_api.repository.RoleRepository;
import com.trainibit.first_api.response.RoleResponse;
import com.trainibit.first_api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleMapper.entityToResponseList(roleRepository.findAll());
    }
}
