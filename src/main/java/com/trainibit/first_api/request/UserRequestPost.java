package com.trainibit.first_api.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Data
public class UserRequestPost {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthdate;
    private UUID federalStateUuid;
    private ArrayList<RoleUserRequest> roles;

    public UserRequestPost(String firstName, String lastName, String email, LocalDate birthdate, UUID federalStateUuid, ArrayList<RoleUserRequest> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.federalStateUuid = federalStateUuid;
        this.roles = roles;
    }
}
