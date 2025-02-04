package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.entity.RolesByUser;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.UserRequestKafka;
import com.trainibit.first_api.request.UserRequestPost;
import com.trainibit.first_api.request.UserRequestPut;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.response.external.PlanetResponse;
import com.trainibit.first_api.service.KafkaProducerService;
import com.trainibit.first_api.service.PlanetService;
import com.trainibit.first_api.service.RoleService;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FederalStateRepository federalStateRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public List<UserResponse> getAll() {
        return userMapper.entityToResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse getByUuid(UUID uuid) {
        return userMapper.entityToResponse(userRepository.findByUuid(uuid));
    }

    @Override
    public UserResponse createUser(UserRequestPost userRequest) {
        User newUser = userMapper.requestToEntity(userRequest);

        newUser.setUuid(UUID.randomUUID());
        newUser.setPlanet(obtainRandomPlanetName());
        newUser.setFederalState(
                federalStateRepository.getFederalStateByUuid(UUID.fromString(userRequest.getFederalStateUuid())));

        List<Role> rolesTemplate = roleService.getAllRoles(); // Roles generales de la base de datos
        List<RolesByUser> roles = new ArrayList<>(); // Roles que tendrá el usuario
        List<UUID> rolesUuidsList = userRequest.getRoles()
                .stream()
                .map(rolesRequests -> UUID.fromString(rolesRequests.getRoleUuid()))
                .toList(); // UUIDs de los roles pasados por JSON

        rolesTemplate.forEach(role -> {
            RolesByUser rolesByUserTemporary = new RolesByUser();
            rolesByUserTemporary.setUser(newUser);
            rolesByUserTemporary.setRole(role);
            rolesByUserTemporary.setUuid(UUID.randomUUID());
            rolesByUserTemporary.setActivated(rolesUuidsList.contains(role.getUuid()));

            roles.add(rolesByUserTemporary);
        });

        newUser.setRoles(roles);
        newUser.setFirstToken(generateRandomToken());

        User savedUser = userRepository.save(newUser);

        UserRequestKafka userResponseKafka = new UserRequestKafka();
        userResponseKafka.setUuid(savedUser.getUuid());
        userResponseKafka.setEmail(savedUser.getEmail());
        userResponseKafka.setFirstToken(savedUser.getFirstToken());

        kafkaProducerService.sendMessage(userResponseKafka);

        return userMapper.entityToResponse(savedUser);
    }

    @Override
    public UserResponse deleteUser(UUID uuid) {
        User userToDelete = userRepository.findByUuid(uuid);
        userRepository.delete(userToDelete);
        return userMapper.entityToResponse(userToDelete);
    }

    @Override
    public UserResponse updateUser(UUID uuid, UserRequestPut userRequest) {
        User existentUser = userRepository.findByUuid(uuid);

        existentUser.setFirstName(
                userRequest.getFirstName() != null ? userRequest.getFirstName() : existentUser.getFirstName());
        existentUser.setLastName(
                userRequest.getLastName() != null ? userRequest.getLastName() : existentUser.getLastName());
        existentUser.setEmail(userRequest.getEmail() != null ? userRequest.getEmail() : existentUser.getEmail());
        existentUser.setBirthdate(
                userRequest.getBirthdate() != null ? LocalDate.parse(userRequest.getBirthdate())
                        : existentUser.getBirthdate());
        existentUser.setPlanet(userRequest.getPlanet() != null ? userRequest.getPlanet() : existentUser.getPlanet());

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        existentUser.setFederalState(
                userRequest.getFederalStateUuid() != null
                        ? federalStateRepository
                                .getFederalStateByUuid(UUID.fromString(userRequest.getFederalStateUuid()))
                        : existentUser.getFederalState());

        HashMap<UUID, Boolean> rolesUpdated = new HashMap<>();
        userRequest.getRoles()
                .forEach(roleUpdated -> rolesUpdated.put(UUID.fromString(roleUpdated.getRoleUuid()),
                        roleUpdated.getActivated()));

        existentUser.getRoles().forEach(roleByUserExistentUser -> roleByUserExistentUser.setActivated(
                rolesUpdated.containsKey(roleByUserExistentUser.getRole().getUuid()) // ¿Se modificó el rol?
                        ? rolesUpdated.get(roleByUserExistentUser.getRole().getUuid()) // Si sí, se obtiene el nuevo
                                                                                       // valor del HashMap
                        : roleByUserExistentUser.getActivated())); // Sino, conserva el valor original

        return userMapper.entityToResponse(userRepository.save(existentUser));
    }

    private String obtainRandomPlanetName() {
        Random random = new Random();
        int randomNumber = random.nextInt(60) + 1;
        PlanetResponse randomPlanet = planetService.getPlanetById(randomNumber);
        return randomPlanet.getResult().getProperties().getName();
    }

    private String generateRandomToken(){
        Random rand = new Random();
        String token = "";

        for(int i = 1; i <= 6; i++)
            token += rand.nextInt(10);

        return token;
    }
}