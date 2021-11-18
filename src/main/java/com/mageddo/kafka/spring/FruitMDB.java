package com.mageddo.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FruitMDB {

    @KafkaListener(topics = "Fruit", groupId = "fruit-group-id")
    void consume(String fruit){
        System.out.println("consumed fruit "+ fruit);
    }
}
