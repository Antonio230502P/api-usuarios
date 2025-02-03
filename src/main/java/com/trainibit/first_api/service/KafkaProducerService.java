package com.trainibit.first_api.service;

import com.trainibit.first_api.response.UserResponseKafka;

public interface KafkaProducerService {
    void sendMessage(UserResponseKafka userResponseKafka);
}
