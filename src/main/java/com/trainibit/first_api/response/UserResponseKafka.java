package com.trainibit.first_api.response;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserResponseKafka implements Serializable {
    private UUID uuid;
    private String email;
    private String firstToken;
}
