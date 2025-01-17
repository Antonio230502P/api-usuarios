package com.trainibit.first_api.mapper.impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse entityToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setUpdatedDate(user.getUpdatedDate());
        userResponse.setUuid(user.getUuid());

        LocalDate birthdate = user.getBirthdate();
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthdate, currentDate);

        userResponse.setBirthDate(birthdate);
        userResponse.setAge(period.getYears() + " years, " + period.getMonths() + " months and " + period.getDays() + " days" );

        userResponse.setPlanet(user.getPlanet());

        return userResponse;
    }

    @Override
    public List<UserResponse> entityToResponseList(List<User> userList) {
        List<UserResponse> userResponseList = new ArrayList<>();

        userList.forEach(user -> userResponseList.add(entityToResponse(user)));

        return userResponseList;
    }

    @Override
    public User requestToEntity(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setBirthdate(userRequest.getBirthdate());

        return user;
    }
}
