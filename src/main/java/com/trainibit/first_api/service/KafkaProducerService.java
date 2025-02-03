package com.trainibit.first_api.service;

import com.trainibit.first_api.response.UserResponseKafkca;

public interface KafkaProducerService {
    void sendMessage(UserResponseKafkca userResponseKafkca);
}
