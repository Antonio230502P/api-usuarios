package com.trainibit.first_api.controller;

import com.trainibit.first_api.request.FederalStateRequest;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.FederalStateService;
import com.trainibit.first_api.service.UserService;
import jakarta.validation.Valid;
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
@RequestMapping("/federal-states")
public class FederalStateController {
    @Autowired
    private FederalStateService federalStateService;

    @GetMapping
    public ResponseEntity<List<FederalStateResponse>> getFederalStates() {
        return ResponseEntity.ok(federalStateService.getAllFederalStates());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<FederalStateResponse> getFederalState(@PathVariable UUID uuid) {
        return ResponseEntity.ok(federalStateService.getFederalStateByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<FederalStateResponse> createFederalState(@Valid @RequestBody FederalStateRequest federalStateRequest) {
        return new ResponseEntity<>(federalStateService.createFederalState(federalStateRequest), CREATED);
    }

    // @DeleteMapping("/{uuid}")
    // public ResponseEntity<UserResponse> deleteUser(@PathVariable UUID uuid) {
    //     return ResponseEntity.status(204).body(userService.deleteUser(uuid)); /
    // }

    // @PutMapping("/{uuid}")
    // public ResponseEntity<UserResponse> updateUser(@PathVariable UUID uuid, @RequestBody UserRequestPut userRequest) {
    //     return ResponseEntity.ok(userService.updateUser(uuid, userRequest));
    // }
}