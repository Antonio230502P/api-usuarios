package com.trainibit.first_api.request;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserRequestKafka implements Serializable {
    private UUID uuid;
    private String email;
    private String firstToken;
}
