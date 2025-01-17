package com.trainibit.first_api.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestPost {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthdate;

    public UserRequestPost(String firstName, String lastName, String email, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
    }
}
