package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.repository.RoleRepository;
import com.trainibit.first_api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
