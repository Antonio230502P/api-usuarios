package com.trainibit.first_api.response;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class RoleResponse {
    private String name;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UUID uuid;
}
