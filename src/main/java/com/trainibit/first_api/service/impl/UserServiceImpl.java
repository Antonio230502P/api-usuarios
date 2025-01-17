package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.response.external.PlanetResponse;
import com.trainibit.first_api.service.PlanetService;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlanetService planetService;

    @Override
    public List<UserResponse> getAll() {
        return userMapper.entityToResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse getByUuid(String uuid) {
        return userMapper.entityToResponse(userRepository.findByUuid(UUID.fromString(uuid)));
    }

    @Override
    public UserResponse createUser(UserRequestPost userRequest) {
        User newUser = userMapper.requestToEntity(userRequest);

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        newUser.setUuid(UUID.randomUUID());
        newUser.setCreatedDate(currentTimeStamp);
        newUser.setUpdatedDate(currentTimeStamp);
        newUser.setPlanet(obtainRandomPlanetName());

        return userMapper.entityToResponse(userRepository.save(newUser));
    }

    @Override
    public UserResponse deleteUser(String uuid) {
        // userRepository.deleteByUuid(UUID.fromString(uuid)); No funciona con el repositorio
        User userToDelete = userRepository.findByUuid(UUID.fromString(uuid));
        userRepository.delete(userToDelete);
        return userMapper.entityToResponse(userToDelete);
    }

    @Override
    public UserResponse updateUser(String uuid, UserRequestPut userRequest) {
        User existentUser = userRepository.findByUuid(UUID.fromString(uuid));

        existentUser.setFirstName(userRequest.getFirstName() != null ? userRequest.getFirstName() : existentUser.getFirstName());
        existentUser.setLastName(userRequest.getLastName() != null ? userRequest.getLastName() : existentUser.getLastName());
        existentUser.setEmail(userRequest.getEmail() != null ? userRequest.getEmail() : existentUser.getEmail());
        existentUser.setBirthdate(userRequest.getBirthdate() != null ? userRequest.getBirthdate() : existentUser.getBirthdate());
        existentUser.setPlanet(userRequest.getPlanet() != null ? userRequest.getPlanet() : existentUser.getPlanet());

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        return userMapper.entityToResponse(userRepository.save(existentUser));
    }

    private String obtainRandomPlanetName(){
        Random random = new Random();
        int randomNumber = random.nextInt(60) + 1;
        PlanetResponse randomPlanet = planetService.getPlanetById(randomNumber);
        return randomPlanet.getResult().getProperties().getName();
    }
}
