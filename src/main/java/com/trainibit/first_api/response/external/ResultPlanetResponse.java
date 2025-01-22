package com.trainibit.first_api.response.external;

import lombok.Data;

@Data
public class ResultPlanetResponse {
    private PropertiesResultPlanetResponse properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}