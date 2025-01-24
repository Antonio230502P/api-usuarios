package com.trainibit.first_api.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RoleUserRequestPost {
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")
    private String roleUuid;
}
