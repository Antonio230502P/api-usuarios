package com.trainibit.first_api.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserRequestPost {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthdate;
    private UUID federalStateUuid;

    public UserRequestPost(String firstName, String lastName, String email, LocalDate birthdate, UUID federalStateUuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.federalStateUuid = federalStateUuid;
    }
}
