package com.trainibit.first_api.controller;

import com.trainibit.first_api.request.RoleRequest;
import com.trainibit.first_api.response.RoleResponse;
import com.trainibit.first_api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getRoles() {
        return ResponseEntity.ok(roleService.getAllRoleResponses());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<RoleResponse> getRole(@PathVariable UUID uuid) {
        return ResponseEntity.ok(roleService.getByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<RoleResponse> postRole(@RequestBody RoleRequest roleRequest) {
        return new ResponseEntity<>(roleService.createRole(roleRequest), CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<RoleResponse> deleteRole(@PathVariable UUID uuid) {
        return ResponseEntity.status(204).body(roleService.deleteResponse(uuid));
    }

    @PutMapping("{uuid}")
    public ResponseEntity<RoleResponse> putRole(@PathVariable UUID uuid, @RequestBody RoleRequest roleRequest) {        
        return ResponseEntity.ok(roleService.updateRole(uuid, roleRequest));
    }
}