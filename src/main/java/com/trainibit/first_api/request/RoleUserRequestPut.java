package com.trainibit.first_api.request;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleUserRequestPut {
    private UUID roleUuid;  
    private Boolean activated;
}
