package com.trainibit.first_api.request;

import java.util.UUID;

import lombok.Data;

@Data
public class FederalStateRequest {
    private String name;
    private UUID uuid;
}