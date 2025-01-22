package com.trainibit.first_api.response;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private UUID uuid;
    private LocalDate birthDate;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String age;
    private String planet;
    private FederalStateResponse federalState;
    private List<RolesByUserResponse> roles;
}
