package com.trainibit.first_api.service;

import com.trainibit.first_api.request.UserRequestKafka;

public interface KafkaProducerService {
    void sendMessage(UserRequestKafka userResponseKafka);
}
