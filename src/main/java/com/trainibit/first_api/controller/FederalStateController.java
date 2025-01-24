package com.trainibit.first_api.controller;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.FederalStateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
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
@EnableCaching
@RequestMapping("/federal-states")
public class FederalStateController {
    @Autowired
    private FederalStateService federalStateService;

    @GetMapping
    @Cacheable(value = "federalStates")

    public List<FederalState> getAllFederalStates() {
        return federalStateService.getAllFederalStates(); // 200
    }

    @GetMapping("/{uuid}")
    @Cacheable(value = "federal-state", key = "#uuid")
    public FederalState getByUuid(@PathVariable UUID uuid) {
        return federalStateService.getFederalStateByUuid(uuid); // 200
    }

    @PostMapping
    public ResponseEntity<FederalStateResponse> createUser(@Valid @RequestBody FederalStateRequest federalStateRequest) {
        return new ResponseEntity<>(federalStateService.createFederalState(userRequest), CREATED); //201 Creado
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable UUID uuid){
        return ResponseEntity.status(204).body(userService.deleteUser(uuid)); //204 Solicitud exitosa pero sin contenido que retornar
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID uuid, @RequestBody UserRequestPut userRequest){
        return ResponseEntity.ok(userService.updateUser(uuid, userRequest)); // Para la actualización de contenido puede retornarse un código 200 o un 400 sin retornar contenido
    }
}
