package com.trainibit.first_api.response.external;

import lombok.Data;

@Data
public class PlanetResponse {
    private String message;
    private ResultPlanetResponse result;
}