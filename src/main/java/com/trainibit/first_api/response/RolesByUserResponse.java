package com.trainibit.first_api.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trainibit.first_api.entity.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class RolesByUserResponse {
    @JsonBackReference
    private User user;

    private RoleResponse role;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UUID uuid;
    private Boolean activated;
}
