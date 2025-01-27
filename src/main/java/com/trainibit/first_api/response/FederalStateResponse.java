package com.trainibit.first_api.response;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class FederalStateResponse implements Serializable {
    private String name;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UUID uuid;
}
