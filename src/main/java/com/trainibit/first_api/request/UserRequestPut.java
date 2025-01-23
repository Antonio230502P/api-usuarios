package com.trainibit.first_api.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Data
public class UserRequestPut {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthdate;
    private String planet;
    private UUID federalStateUuid;
    private ArrayList<RoleUserRequestPut> roles;

    public UserRequestPut(String firstName, String lastName, String email, LocalDate birthdate, String planet, UUID federalStateUuid, ArrayList<RoleUserRequestPut> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.planet = planet;
        this.federalStateUuid = federalStateUuid;
        this.roles = roles;
    }
}
