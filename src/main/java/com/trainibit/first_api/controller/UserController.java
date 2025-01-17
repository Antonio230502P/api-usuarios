package com.trainibit.first_api.controller;

import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.UserService;
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

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String uuid) {
        return ResponseEntity.ok(userService.getByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequestPost userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable String uuid){
        return ResponseEntity.ok(userService.deleteUser(uuid));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String uuid, @RequestBody UserRequestPut userRequest){
        return ResponseEntity.ok(userService.updateUser(uuid, userRequest));
    }
}
