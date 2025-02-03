package com.trainibit.first_api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainibit.first_api.response.UserResponseKafkca;
import com.trainibit.first_api.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topicName = "user_registered";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void sendMessage(UserResponseKafkca userResponseKafkca) {
        try{
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, userResponseKafkca.getUuid().toString(), objectMapper.writeValueAsString(userResponseKafkca));
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + userResponseKafkca.getEmail() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            userResponseKafkca.getEmail() + "] due to : " + ex.getMessage());
                }
            });
        }catch (Exception e){
            throw new RuntimeException("Error converting UserResponseKafkca to JSON", e);
        }
    }
}
